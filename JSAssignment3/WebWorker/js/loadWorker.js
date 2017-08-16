//single global instance of worker
var w;

/*
    Method to start worker
*/
function startWorker() {
    if(typeof(Worker) !== "undefined") {
        if(typeof(w) == "undefined") {
            w = new Worker("js/worker.js");
        }
        w.onmessage = function(event) {
            document.getElementById("result").innerHTML = event.data;
        };
    } else {
        document.getElementById("result").innerHTML = "Sorry, your browser does not support Web Workers...";
    }
}

/*
    Method to stop worker
*/
function stopWorker() { 
    w.terminate();
    w = undefined;
}