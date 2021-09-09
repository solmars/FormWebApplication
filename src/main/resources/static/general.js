function refreshVotes() {
	//ajax example
    var request = new XMLHttpRequest();
    var vBoard = document.getElementById("votes");

    request.onload = function () {
        vBoard.innerHTML = this.responseText;
        vBoard.style.color = "black";
        setTimeout(refreshVotes, 10000);
    };

    request.ontimeout = function () {
        vBoard.innerHTML = "Server timeout, still trying ...";
        vBoard.style.color = "red";
        setTimeout(refreshVotes, 100);
    };

    request.onerror = function () {
        vBoard.innerHTML = "No server reply, still trying ...";
        vBoard.style.color = "red";
        setTimeout(refreshVotes, 5000);
    };

    request.open("GET", "/url", true);
    request.timeout = 5000;
    request.send();
}
function hasDuplicates(array) {
    const set = new Set(array);
    return array.length !== set.size;
}


function stringToHTML(str) {
    let parser = new DOMParser();
    let doc = parser.parseFromString(str, 'text/html');
    return doc.body;
}

function findDataUrlElement(urlName) {
    let childNodeArray = document.getElementById('sidebarDiv').getElementsByTagName('a');
    for (i = 0; i < childNodeArray.length; i++) {
        if (childNodeArray[i].dataset.url === urlName) {
            return childNodeArray[i];
        }
    }
}
function changeUrl(url, title) {
    window.history.pushState('data', title, url);
}

function createLabel(text) {
    let label = document.createElement('label');
    label.textContent = text;
    return label;
}

function cleanMainDiv() {
    const node = document.getElementById('mainDiv');
    while (node.hasChildNodes()) {
        node.removeChild(node.firstChild);
    }
}


function getData(url) {
    return axios.get(url);
}
function postData(url, info) {
    return axios.post(url, info); // return the promise

}
