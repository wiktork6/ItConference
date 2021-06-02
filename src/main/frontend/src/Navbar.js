const Navbar = () =>{
    return(
        <nav className="navbar">
            <h1> It Conference</h1>
            <div className = "links">
                <a href='/'>Home</a>
                <a href='/register' style={{
                    color:"white",
                    backgroundColor:"#6495ED",
                    borderRadius: '8px'
                }}>Register to a Lecture</a>
            </div>
        </nav>

    );
}

export default Navbar;