function howToUse_loadDOM() {
    let mainDiv = document.getElementById('mainDiv');
    mainDiv.className = 'indexForm';
    let containerDiv = document.createElement('div');
    containerDiv.className = 'indexForm';
    mainDiv.appendChild(containerDiv);
    let formCreationInfo = document.createElement('p');
    formCreationInfo.textContent = "To create a form, go to 'Form Creation tab' in the sidebar, "
        + "this requires some knowledge of the developed application's grammar "
        + "if you want to develop complex rules. Some examples of grammar rules are: (note that v_1, v_2, v_3 and v_4 refer to variable names)";
    const listContainer = document.createElement('ul');
    listContainer.className = 'indexForm';
    const rule1 = howToUse_createLi("Making questions obligatory to answer: v_1 IS OBLIGATORY;");
    
    listContainer.appendChild(rule1);
    const rule2 = howToUse_createLi("Conditional obligatoriness rule: IF v_3 = \"Justified\" THEN v_4 OBLIGATORY;");
    listContainer.appendChild(rule2);
    const rule3 = howToUse_createLi("Appending comparison rules: v_2 > v_1;");
    listContainer.appendChild(rule3);
    let formAnswerInfo = document.createElement('p');
    formAnswerInfo.textContent = "To answer a form, you go to 'Answer Form tab' in the sidebar," +
        " as long as you answer according the rules decided by the form creator, the form answers will be saved, if you don't, the application notifies you of what you need to correct.";
    containerDiv.appendChild(formCreationInfo);
    containerDiv.appendChild(listContainer);

    containerDiv.appendChild(formAnswerInfo);

}
function howToUse_createLi(content) {
    const li = document.createElement('li');
    li.textContent = content;
    return li;
} 