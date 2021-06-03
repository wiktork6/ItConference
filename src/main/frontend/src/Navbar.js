import { Link } from 'react-router-dom';
import siilogo from './siilogo.png';

const Navbar = () =>{
    return(
        <nav className="navbar">
            <img src={siilogo} alt = "Logo"/>
            <Link to='/'><h1> It Conference</h1></Link>
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