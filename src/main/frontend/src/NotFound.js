import { Link } from 'react-router-dom';
const NotFound = () =>{
    return (
        <div className="not-found">
            <h2>404 not found</h2>
            <p>Wrong url</p>
            <Link to = '/'>Home</Link>
        </div>

    );
}

export default NotFound;