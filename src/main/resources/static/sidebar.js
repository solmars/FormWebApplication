/*
 * Remember, we don't want to refresh the page, as we only want to have a single html file
 As such, we must purely manipulate the DOM.
 */
function formWebAppOnLoad() {
    activateSidebarBehaviour();
    let mapping = window.location.href.split('/');
    let lastMapping = mapping[mapping.length - 1];
    if (lastMapping !== 'index.html' && lastMapping !== '') {
        findDataUrlElement('/' + lastMapping).click();
    } else {
        findDataUrlElement('/formCreation').click(); // default/homepage
    }
}
function sidebarRedirect(activeElement) {
    changeDOMAccordingToUrl(activeElement);
    changeUrl(activeElement.dataset.url, activeElement.dataset.url);
}
function changeDOMAccordingToUrl(activeElement) {
    cleanMainDiv();
    switch (activeElement.dataset.url) {
        case '/about':
            about_loadDOM();
            break;
        case '/howToUse':
            howToUse_loadDOM();
            break;
        case '/answerForm':
            formAnswer_loadDOM();
            break;
        case '/formCreation':
            form_loadDOM();
            break;
    }
}
function activateSidebarBehaviour() {
    let childNodeArray = document.getElementById('sidebarDiv').getElementsByTagName('a');
    for (i = 0; i < childNodeArray.length; i++) {
        childNodeArray[i].onclick = function () {
            this.className = 'active';
            let brotherNodes = this.parentNode.getElementsByTagName('a');
            for (i = 0; i < brotherNodes.length; i++) {
                if (brotherNodes[i] !== this) {
                    brotherNodes[i].className = '';
                }
            }
            sidebarRedirect(this);
        };
    }

}
