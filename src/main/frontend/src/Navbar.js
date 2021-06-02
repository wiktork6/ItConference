import { Link } from 'react-router-dom';
const Navbar = () =>{
    return(
        <nav className="navbar">
            <h1> It Conference</h1>
            <div className = "links">
                <Link to='/'>Home</Link>
                <Link to='/lectures' style={{
                    color:"white",
                    backgroundColor:"#6495ED",
                    borderRadius: '8px'
                }}>Check your lectures</Link>
            </div>
        </nav>
    );
}
export default Navbar;