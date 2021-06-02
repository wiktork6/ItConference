const LectureList = (props) => {
    const lectures = props.lectures;
    const title = props.title;
    return(
        <div className="lecture-list">
            <h2>{ title }</h2>
            {lectures.map((lecture)=>(
                <div className="lecture-preview" key={lecture.id}>
                    <h2>{lecture.subject}</h2>
                    <p>Starts: {lecture.startDate.substring(11,16)}</p>
                    <p>Ends: {lecture.endDate.substring(11,16)}</p>
                    <p>Empty Slots: {5-lecture.registeredParticipants}</p>
                    <button>Description</button>
                </div>
            ))}
        </div>

    );

}
export default LectureList;