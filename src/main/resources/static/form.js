
function form_loadDOM() {
    document.getElementById('mainDiv')
        .appendChild(document.getElementById('formCreationTemplate')
            .content
            .querySelector('#indexFormTemplate').cloneNode(true));
}
async function createFormObject() {
    let formValidationLabel = document.getElementById("formValidation");
    let variableNames = document.getElementsByName("variableNameInput");
    let textVariableNames = [];
    for (i = 0; i < variableNames.length; i++) {
        textVariableNames.push(variableNames[i].value);
    }
    var valid = !hasDuplicates(textVariableNames); // can't have duplicate variables
    if (valid) {
        try {
            await createForm();
            await swal({
                title: "Success!",
                text: "You have successfully created the form!",
                icon: "success"
            });
            // created, clean the scene, without altering URL
            location.reload();

        } catch (error) {
            await swal({
                title: "Failure!",
                text: "The form couldn't be successfully created due to the following errors:\n\n" + error.response.data + "\n\nPlease fix the described problems or contact your administrator.",
                icon: "error"
            });

        }
    } else {
        formValidationLabel.className = 'notValid formLbl';
        formValidationLabel.textContent = 'The form is not valid for creation due to duplicate variable names!';
    }
    return false;
}

function createForm() {
    let formName = document.getElementsByName("formNameInput")[0].value;
    let formDescription = document.getElementsByName("formDescriptionInput")[0].value;

    let variableInputs = document.getElementsByName("variableNameInput");
    let descriptionInputs = document.getElementsByName("descriptionNameInput");
    let regexInputs = document.getElementsByName("regexValidationInput");
    let grammarRulesInput = document.getElementsByName("grammarRulesInput");
    let dataTypeInputs = document.getElementsByName("dataTypesInput");
    let grammarStrings = [];
    for (i = 0; i < grammarRulesInput.length; i++) {
        let grammarRule = grammarRulesInput[i].value;
        if (grammarRule) {
            grammarStrings.push(grammarRule);
        }
    }
    /*note that, in reality, form attributes don't each have grammar rules,
     *  as they are actually relative to the form,
     its just for presentation sake for the user to write the associated grammar rules
     to each attribute
     */
    let otherGrammarRules = document.getElementsByName("newGrammarRulesInput");
    for (i = 0; i < otherGrammarRules.length; i++) {
        let grammarRule = otherGrammarRules[i].value;
        if (grammarRule) {
            grammarStrings.push(otherGrammarRules[i].value);
        }
    }
    var formObj = { name: formName, description: formDescription, attributes: [], grammarRules: grammarStrings };
    for (i = 0; i < variableInputs.length; i++) {
        let formAttribute = {
            variableName: variableInputs[i].value,
            description: descriptionInputs[i].value,
            dataType: dataTypeInputs[i].value,
            regularExp: regexInputs[i].value
        };
        formObj.attributes.push(formAttribute);
    }
    return postData('/forms', formObj);
}

function addGrammarRule(id) {
    let total_rules = document.getElementById("total_rules");
    let new_input = "<br>" + "<input type='text' id='new_" + total_rules.value + "' name = 'newGrammarRulesInput'>" + "<br>";
    document.getElementById("new_rules" + id).appendChild(stringToHTML(new_input));
    total_rules.value = parseInt(total_rules.value) + 1;
}
function addFormAttribute() {
    let total_attributes = document.getElementById("total_attributes");
    let clone = document.getElementById('formAttributeTemplate').cloneNode(true);
    //change ids
    clone.id = clone.id + total_attributes.value;
    clone.querySelector("button").id = total_attributes.value;
    clone.querySelector("div").innerHTML = ''; // don't copy grammar rule lines
    clone.querySelector("div").id = 'new_rules' + total_attributes.value;
    let inputs = clone.getElementsByTagName("input");

    for (var i = 0; i < inputs.length; i++) {
        inputs[i].value = '';
    }

    document.getElementById("new_form_attributes").appendChild(clone);
    document.getElementById("new_form_attributes").insertAdjacentHTML('beforeend', "<br><br>");

    total_attributes.value = parseInt(total_attributes.value) + 1;
}