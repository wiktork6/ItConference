import useFetch from "./useFetch";
import LectureList from "./LectureList";

const Home = () => {
    const {data:lectures, error} = useFetch('http://localhost:8080/lectures')
    return (
        <div className="home">
            Welcome to our IT Conference, which will take place on the 1st of June 2021. Please register your participation in one of 3 main fields.
            {error && <div>{error}</div>}
            {lectures && <LectureList lectures = {lectures.filter((lecture)=>lecture.title === "Artificial Intelligence")} title = "Artificial Intelligence"/>}
            {lectures && <LectureList lectures = {lectures.filter((lecture)=> lecture.title === "Web Technologies")} title = "Web Technologies"/>}
            {lectures && <LectureList lectures = {lectures.filter((lecture)=> lecture.title === "Embedded Systems")} title = "Embedded Systems"/>}
        </div>
    );
}
export default Home;