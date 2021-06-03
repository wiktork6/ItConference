import {useState} from 'react';

const Login = () => {
    const [login, setLogin] = useState('');
    const [notification, setNotification] = useState('');


    const handleSubmit = (e)=>{
        e.preventDefault();
        fetch('http://localhost:8080/users/').then(()=>{
        })
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