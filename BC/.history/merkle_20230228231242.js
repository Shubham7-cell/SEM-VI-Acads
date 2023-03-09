var merkle = require("merkle");
var abcde = [
    "Noman->100->Varun",
    "Noman->100->Shubham",
    "Shubham->100->Varun",
    "Shubham->100->Noman",
    "Varun->100->Shubham",
    "Varun->100->Noman",
    "Zedx->100->Suyog",
    "Zedx->100->Suyog",
    "Zedx->100->Suyog101",
    "Hiba->100->Suyog102",
];

var tree = merkle("sha1").sync(abcde);

merkle("sha1").async(abcde, function(err, tree) {
    // ...
});

// Stream style -- streams root hash
var merkleStreamRoot = merkle("sha1");
merkleStreamRoot.pipe(process.stdout);

// Stream style -- streams json tree
var es = require("event-stream");
var merkleStreamJson = merkle("sha1").json();
merkleStreamJson.pipe(es.stringify()).pipe(process.stdout);

abcde.forEach(function(letter) {
    merkleStreamJson.write(letter);
});

merkleStreamJson.end();