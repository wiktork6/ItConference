import useFetch from "./useFetch";
import {useParams} from "react-router-dom";
import {useHistory} from 'react-router-dom'
const Account = () =>{
    const {login} = useParams();
    const {data:user, error} = useFetch(`http://localhost:8080/users/${login}` )
    const history = useHistory();

    const handleClick = (lectureId) =>{
        fetch(`http://localhost:8080/users/${login}/${lectureId}`, {
            method: "DELETE"
        }).then(()=>{
            history.go(0);
        })
    };


    return (
        <div className="my-account">
            {error && <div>{"User " + login + " does not exist"}</div>}
            {user && <div>
                <p>Email: {user.email}</p> <button>Update Mail</button>
                <p>Login: {user.login}</p>
                <div className="lecture-list">
                    {user.registeredLectures.map((lecture)=>(
                        <div className="lecture-preview" key={lecture.id}>
                            <h1>{lecture.title}</h1>
                            <h2>{lecture.subject}</h2>
                            <p>Starts: {lecture.startDate.substring(11,16)}</p>
                            <p>Ends: {lecture.endDate.substring(11,16)}</p>
                            <button onClick={()=>handleClick(lecture.id)}>UnRegister</button>
                        </div>
                    ))}
                </div>
            </div>}
        </div>
    );
}
export default Account;