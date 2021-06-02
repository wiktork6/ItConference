import Navbar from "./Navbar";
import Home from "./Home";
import {BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import LectureDetails from "./LectureDetails";

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
                        <Route exact path="/lectures/:lectureId">
                            <LectureDetails/>
                        </Route>
                    </Switch>
                </div>
            </div>
        </Router>
  );
}

export default App;
