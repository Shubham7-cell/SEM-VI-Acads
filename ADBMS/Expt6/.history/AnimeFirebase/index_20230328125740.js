const admin = require("firebase-admin");

const serviceAccount = require("./animefirebase-firebase-adminsdk-1x9xu-8b0b0b0b0b.json");

admin.initializeApp({
    credential: admin.credential.cert(serviceAccount),
});

const db = admin.firestore();