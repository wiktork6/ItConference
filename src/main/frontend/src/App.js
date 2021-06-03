import Navbar from "./Navbar";
import Home from "./Home";
import {BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import LectureDetails from "./LectureDetails";
import SignUp from "./SignUp";
import NotFound from "./NotFound";
import Login from "./Login";

function App() {
    return (
        <Router>
            <div className="App">
                <Navbar />
                <div className="content">
                    <Switch>
                        <Route exact path="/">
                            <Home />
                        </Route>
                        <Route exact path="/users">

                        </Route>
                        <Route exact path="/lectures">
                            <Login/>
                        </Route>
                        <Route exact path="/lectures/:lectureId">
                            <LectureDetails/>
                        </Route>
                        <Route exact path="/lectures/:lectureId/signup">
                            <SignUp/>
                        </Route>
                        <Route path='*'>
                            <NotFound/>
                        </Route>
                    </Switch>
                </div>
            </div>
        </Router>
  );
}

export default App;
