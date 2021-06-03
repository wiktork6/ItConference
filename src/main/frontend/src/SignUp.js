import {useState} from 'react';
import {useHistory} from 'react-router-dom'
import { useParams } from 'react-router-dom';
import useFetch from "./useFetch";

const SignUp = () => {

    const [email, setEmail] = useState('');
    const [login, setLogin] = useState('');
    const [notification, setNotification] = useState('');
    const {lectureId} = useParams();
    const history = useHistory();
    const {data: lecture, error } = useFetch(`http://localhost:8080/lectures/${lectureId}`)

    const emailIsValid  = (email) => {
        return /\S+@\S+\.\S+/.test(email)
    }

    const handleSubmit = (e)=>{
        e.preventDefault();
        if(!emailIsValid(email)){
            return setNotification("Wrong Email!");
        }
        const user = {login, email};
        fetch('http://localhost:8080/users?lectureId=' + lectureId,{
            method: 'POST',
            headers: {"Content-Type": "application/json"},
            body: JSON.stringify(user)
        }).then((res)=>{
            if(!res.ok){
                // setNotification("Maximum number of participants was achieved")
                res.json()
                    .then((json)=>{setNotification(json.message)})
                    .catch((err) => setNotification("Something went wrong " + err))
            }else{
                history.push('/');
            }
        })
    }



    return(
        <div className = "SignUp">
            {error && <div>error</div>}
            {lecture && (
            <form onSubmit={handleSubmit}>
                <h2> Sign-Up to {lecture.title} - {lecture.subject} </h2>
                <label>Email:</label>
                <input
                    type="text"
                    required
                    value={email}
                    onChange={(e)=>{
                        setEmail(e.target.value)
                    }}
                />
                <label>Login:</label>
                <input
                    type="text"
                    required
                    value = {login}
                    onChange={(e)=>{
                        setLogin(e.target.value)
                    }}
                />
                <button>Sign-Up!</button>
            </form>)}
            <p>{notification}</p>
        </div>

    );
}

export default SignUp;