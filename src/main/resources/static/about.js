function about_loadDOM() {
    const mainDiv = document.getElementById('mainDiv');
    const containerDiv = document.createElement('div');
    containerDiv.className = 'indexForm';
    containerDiv.style = 'font-size:1.0em;';

    const p1 = about_createParagraph("This web application was made by using the spring framework for the 'backend', and html, css, javascript for the 'front end'.");
    const p2 = about_createParagraph('The following are all of the technologies used to obtain the back end functionalities: ');
    containerDiv.appendChild(p1);
    containerDiv.appendChild(p2);

    const listContainer = document.createElement('ul');
    listContainer.className='indexForm formLbl';
    listContainer.style = 'font-size:0.9em;width:300px;'
    listContainer.appendChild(about_createList('Spring HATEOAS'))
    listContainer.appendChild(about_createList('Spring Web'))
    listContainer.appendChild(about_createList('Other spring boot generic usages'))
    listContainer.appendChild(about_createList('H2 in-memory database'))
    listContainer.appendChild(about_createList('ANTLR parser'))
    containerDiv.appendChild(listContainer);

    const p3 = about_createParagraph('The front end exclusively uses javascript to load and manipulate the DOM as an example of avoiding refreshing to save bandwidth.');
    containerDiv.appendChild(p3);

    mainDiv.appendChild(containerDiv);
}
function about_createParagraph(content) {
    const paragraph = document.createElement('p');
    paragraph.textContent = content;
    return paragraph;
}
function about_createList(content) {
    const li = document.createElement('li');
    li.textContent = content;
    return li;
} 