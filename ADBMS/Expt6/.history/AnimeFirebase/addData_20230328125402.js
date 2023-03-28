const data = {
    name: "John Doe",
    email: "johndoe@example.com",
};

const res = await db.collection("users").doc("john-doe").set(data);
console.log("Data added to Firestore!");