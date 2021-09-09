

async function formAnswer_loadDOM() {
    const mainDiv = document.getElementById('mainDiv');
    mainDiv.className = 'indexForm';
    let forms = await getData('/formsDTO');
    let data = forms.data;
    //pure DOM creation
    for (let i = 0; i < data.length; i++) {
        const div = document.createElement('div');
        div.dataset.id = data[i].id;

        div.className = 'formAnswerBorders';
        let innerDiv = document.createElement('div');
        let lbl = createLabel("Form id: " + data[i].id);
        lbl.className = 'formLbl formLbl--answer'
        innerDiv.appendChild(lbl);
        div.appendChild(innerDiv);
        innerDiv = document.createElement('div');
        lbl = lbl.cloneNode(true);
        lbl.textContent = "Form name: " + data[i].name;
        innerDiv.appendChild(lbl);
        div.appendChild(innerDiv);
        innerDiv = document.createElement('div');
        lbl = lbl.cloneNode(true);
        lbl.textContent = "Form description: " + data[i].description;
        innerDiv.appendChild(lbl);
        div.appendChild(innerDiv);

        let previewBtn = document.createElement('button');
        let answerBtn = document.createElement('button');
        div.appendChild(previewBtn);
        div.appendChild(answerBtn);
        previewBtn.className = 'btn';
        previewBtn.onclick = function () {
            previewQuestions(this);
        };
        answerBtn.onclick = function () {
            listForm(this);
        };

        previewBtn.textContent = 'Preview questions';
        answerBtn.className = 'btn--answer';
        answerBtn.textContent = 'Answer this form';



        mainDiv.appendChild(div);
        mainDiv.appendChild(document.createElement('br'));
        mainDiv.appendChild(document.createElement('br'));

    }
}
async function previewQuestions(node) {
    const parentDiv = node.parentNode;

    if (!node.classList.contains('active')) {
        let form = await getData('forms/' + node.parentNode.dataset.id);
        let attributes = form.data.attributes;
        const containerDiv = document.createElement('div');
        containerDiv.appendChild(document.createElement('br'));

        containerDiv.className = 'indexForm';
        containerDiv.id = node.parentNode.dataset.id;
        for (let i = 1; i < attributes.length + 1; i++) {
            let question = createLabel('Question ' + i + ': ' + attributes[i - 1].description);
            question.className = 'formLbl formLbl--answer'
            containerDiv.appendChild(question);
            containerDiv.appendChild(document.createElement('br'));
            containerDiv.appendChild(document.createElement('br'));
        }
        node.textContent = 'Hide questions';
        parentDiv.appendChild(containerDiv);
        node.classList.add('active');
    }
    else {
        parentDiv.removeChild(document.getElementById(node.parentNode.dataset.id));
        node.classList.remove('active');
        node.textContent = 'Preview questions';

    }
}
async function listForm(node) {
    cleanMainDiv();
    let form = await getData('forms/' + node.parentNode.dataset.id);
    const mainDiv = document.getElementById('mainDiv');

    let attributes = form.data.attributes;
    const containerDiv = document.createElement('div');
    containerDiv.className = 'questionsContainer';
    containerDiv.id = node.parentNode.dataset.id;
    const br = document.createElement('br');
    for (let i = 0; i < attributes.length; i++) {
        let subContainer = document.createElement('div');
        subContainer.className = "questionAnswerPair";
        let question = createLabel('Question: ' + attributes[i].description + ' (' + attributes[i].variableName + ')');
        question.className = "question";
        question.dataset.variable = attributes[i].attributeId;
        let answer = createLabel('Answer: ');

        let input = document.createElement('input');
        input.type = 'text';
        input.className = "answer formLbl formLbl--Answer";
        subContainer.appendChild(question);
        subContainer.appendChild(document.createElement('br'));
        subContainer.appendChild(answer);
        subContainer.appendChild(input);
        subContainer.appendChild(document.createElement('br'));
        subContainer.appendChild(document.createElement('br'));

        containerDiv.append(subContainer);
    }
    let submitBtn = document.createElement('button');
    submitBtn.className = 'btn--answer';
    submitBtn.textContent = 'Submit form answers';
    submitBtn.onclick = function () {
        createFormAnswer();
    }
    containerDiv.appendChild(submitBtn);
    mainDiv.appendChild(containerDiv);


}
async function createFormAnswer() {
    let formId = document.getElementsByClassName('questionsContainer')[0].id;
    let formAnswer = {
        formId :formId,
        answers: []
     }
    const pairs = document.getElementsByClassName('questionAnswerPair');
    for (let i = 0; i < pairs.length; i++) {
        let variable = pairs[i].getElementsByClassName('question')[0].dataset.variable;
        let answer = pairs[i].getElementsByClassName('answer')[0].value;
        formAnswer.answers.push({ variableId: variable, answer: answer });
    }
    try {
        await postData('/formAnswer', formAnswer);
        await swal({
            title: "Success!",
            text: "You have successfully saved your answers!",
            icon: "success"
        });
        // created, clean the scene, without altering URL
        location.reload();

    } catch (error) {
        await swal({
            title: "Failure!",
            text: "The answers couldn't be successfully saved due to the following errors:\n\n" + error.response.data + "\n\nPlease fix the described problems or contact your administrator.",
            icon: "error"
        });
    }

    return false;
}


