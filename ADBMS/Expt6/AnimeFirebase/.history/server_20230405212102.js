const express = require("express");
const app = express();

const admin = require("firebase-admin");
const credentials = require("./key.json");

admin.initializeApp({
    credential: admin.credential.cert(credentials),
});

app.use(express.json());

app.use(express.urlencoded({ extended: true }));

const db = admin.firestore();

//POST request
app.post("/create", async(req, res) => {
    try {
        console.log(req.body);
        const id = req.body.email;
        const userJson = {
            email: req.body.email,
            firstName: req.body.firstName,
            lastName: req.body.lastName,
        };
        // const response = db.collection("users").doc(id).set(userJson);
        const response = db.collection("users").add(userJson);
        res.send(response);
    } catch (error) {
        res.send(error);
    }
});

//READ all request
app.get("/read/all", async(req, res) => {
    try {
        const usersRef = db.collection("users");
        const response = await usersRef.get();
        let responseArr = [];
        response.forEach((doc) => {
            responseArr.push(doc.data()); // data->each doc
        });
        res.send(responseArr);
    } catch (error) {
        res.send(error);
    }
});

//READ one request

app.get("/read/:id", async(req, res) => {
    try {
        const usersRef = db.collection("users").doc(req.params.id);
        const response = await usersRef.get();

        res.send(response.data());
    } catch (error) {
        res.send(error);
    }
});
//http://localhost:8080/create

const PORT = process.env.PORT || 8080;
app.listen(PORT, () => {
    console.log(`Server is running on port ${PORT}.`);
});