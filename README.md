# IT Conference Management
Clone the repository and open it in terminal.
Change your directory to 
### `src/main/frontend`
and type 
### `npm install`
to install all javascript dependencies.
Then start spring boot DemoApplication and type in the terminal.
### `npm start`
Open [http://localhost:3000](http://localhost:3000) to view it in the browser. <br/>
Server runs on [http://localhost:8080](http://localhost:8080).
## API endpoints

### GET
`/users` returns list of all users <br/>
`/users/:login` returns user with a specific login <br/>
`/lectures` returns list of all lectures <br/>
`/lectures/:lectureId` returns lecture with a specific id <br/>
### POST
`/users?lectureId=:lectureId` sends user object in the body with email and login and registers the user to the lecture with a specific id<br/>
### PUT
`/users/:login?email=:newEmail` changes old email to newEmail for user with a specific login 
### DELETE
`/users/:userId` deletes user with a specific id<br/>
`/users/:login/:lectureId` deletes lecture from the user who had previously signed up for that lecture



