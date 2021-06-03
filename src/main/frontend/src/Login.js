import {useState} from 'react';
import {useHistory} from 'react-router-dom'

const Login = () => {
    const [login, setLogin] = useState('');
    const history = useHistory();


    const handleSubmit = (e)=>{
        e.preventDefault();
        history.push('/users/' + login)

    }
    return(
        <div className = "login">
            <h2>If you want to see lectures that you have signed up to, please provide your login</h2>
            <form onSubmit={handleSubmit}>
                <label>Login</label>
                <input
                    type="text"
                    required
                    value = {login}
                    onChange={(e)=>{
                        setLogin(e.target.value)
                    }}
                />
                <button>Search</button>
            </form>
        </div>

    );
}

export default Login;