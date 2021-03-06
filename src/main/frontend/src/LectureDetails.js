import {Link, useParams} from 'react-router-dom';
import useFetch from "./useFetch";

const LectureDetails = () => {

    const {lectureId} = useParams();
    const {data:lecture, error} = useFetch(`http://localhost:8080/lectures/${lectureId}`)

    return (
        <div className="lecture-details">
            { error && <div>{error}</div>}
            {lecture && (
                <article>
                    <h2>{lecture.title}</h2>
                    <p>{lecture.subject}</p>
                    <p>Starts: {lecture.startDate.substring(11,16)}</p>
                    <p>Ends: {lecture.endDate.substring(11,16)}</p>
                    <p>Available Slots: {5-lecture.registeredParticipants}</p>
                    <div>{lecture.lecturePlan}</div>
                    <Link to={'/lectures/' + lectureId + '/signup'}>
                        <button>Sign-up!</button>
                    </Link>
                    <div className="registered-users">
                        <h2>Registered Users</h2>
                        {lecture.registeredUsers.map((user)=>(
                            <div className="user-preview" key={user.id}>
                                <p>{user.login}</p>
                                <p>{user.email}</p>
                            </div>
                        ))}
                    </div>
                </article>
            )}
        </div>

    );
}

export default LectureDetails;