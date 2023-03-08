var merkle = require("merkle");
var abcde = ["a", "b", "c", "d", "e"];

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