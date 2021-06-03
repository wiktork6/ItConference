import {useHistory, useParams} from "react-router-dom";
import {useState} from 'react';

const EmailUpdate = () =>{
    const {login} = useParams();
    const [email, setEmail] = useState('');
    const history = useHistory();
    const [notification, setNotification] = useState('');

    const emailIsValid  = (email) => {
        return /\S+@\S+\.\S+/.test(email)
    }

    const handleSubmit = (e)=>{
        e.preventDefault();
        if(!emailIsValid(email)){
            return setNotification("Wrong Email!");
        }
        fetch('http://localhost:8080/users/'+login +'?email=' + email,{
            method: 'PUT',
        }).then((res)=>{
            if(!res.ok){
                res.json()
                    .then((json)=>{setNotification(json.message)})
                    .catch((err) => setNotification("Something went wrong " + err))
            }else{
                history.push('/users/' + login)
            }
        })
    }
    return(
        <div className = "login">
            <h2>Please input new email</h2>
            <form onSubmit={handleSubmit}>
                <label>E-mail</label>
                <input
                    type="text"
                    required
                    value = {email}
                    onChange={(e)=>{
                        setEmail(e.target.value)
                    }}
                />
                <button>Search</button>
            </form>
            <p>{notification}</p>
        </div>
    );
}

export default EmailUpdate;