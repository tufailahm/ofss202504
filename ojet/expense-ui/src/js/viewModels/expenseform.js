define(
    [
        'knockout',
        'ojs/ojasyncvalidator-length',
        'ojs/ojvalidator-regexp',
        'ojs/ojinputtext',
        'ojs/ojformlayout',
        'ojs/ojvalidationgroup',
        'ojs/ojbutton'
    ],
    function (ko, AsyncLengthValidator, RegExpValidator) {
        function ExpenseFormViewModel() {

            var self = this;

            this.guestId = ko.observable();
            this.guestName = ko.observable();
            this.mobileNumber = ko.observable();
            this.monthlyIncome = ko.observable();
            this.monthlyexpense = ko.observable()
            this.balance = ko.observable();



            this.mobileValidator = new RegExpValidator({
                pattern: "^[0-9]{10}$",
                hintMessage: "Enter exactly 10 digits",
                messageDetail: "Invalid mobile number format"
            });


            this.nameLengthValidator = new AsyncLengthValidator({
                min: 5,
                hintMessage: "Enter more than 5 characters",
                messageDetail: "Invalid name"
            })

            //when we open the page , we treat it as invalid
            self.isFormInvalid = ko.observable(true);
            // Check validity of the group
            this.groupValidChanged = (event) => {
                // 'valid' means all fields are good, 'invalidHidden' or 'invalidShown' means not valid
                self.isFormInvalid(event.detail.value !== 'valid');
            };



            self.checkFormValidity = function () {
                // let groupValid = document.getElementById('expenseForm').valid === 'valid';
                // self.isFormInvalid(!groupValid);
                // console.log("Is Form InValid" + self.isFormInvalid())

            };





            this.message = ko.observable();

            this.saveExpense = () => {
                console.log("Save Expense Called")

                let tracker = document.getElementById('expenseForm');
                if (tracker.valid !== 'valid') {
                    tracker.showMessages();
                    tracker.focusOn('@firstInvalidShown');
                    console.warn("Form has errors. Cannot save.");
                    return;
                }
                else {
                    this.message(this.guestName() + " your expense Details Saved successfully")
                }

            }

            this.updateExpense = () => {
                console.log("Update Expense called ");
                this.message(this.guestName() + " your expense Details Updated successfully")

            }
        }
        return ExpenseFormViewModel;
    })