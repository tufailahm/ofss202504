define(
    [
        'knockout',

        'ojs/ojtable',
        'ojs/ojmodel',
        'collections/ExpenseCollection',
        'ojs/ojcollectiondataprovider',

        'ojs/ojasyncvalidator-length',
        'ojs/ojvalidator-regexp',
        'ojs/ojinputtext',
        'ojs/ojformlayout',
        'ojs/ojvalidationgroup',
        'ojs/ojbutton'
    ],
    function (ko, ojtable, ojmodel, ExpenseCollection, CollectionDataProvider, AsyncLengthValidator, RegExpValidator) {
        function ExpenseFormViewModel() {

            var self = this;


            // Collection
            self.collection = new ExpenseCollection();
            self.dataProvider = ko.observable();

            self.collection.fetch({
                success: function () {
                    self.dataProvider(new CollectionDataProvider(self.collection));
                    console.log("Data loaded");
                    self.collection.each(function (model) {
                        console.log(model.toJSON());

                    });
                },
                error: function (jqXHR, textStatus) {
                    console.error("Fetch error:", textStatus);
                }
            });



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
                    // Save the expense using the REST endpoint
                    alert("Saving now");

                    var newExpense = {
                        guestId: self.guestId(),
                        guestName: self.guestName(),
                        mobileNumber: self.mobileNumber(),
                        monthlyIncome: self.monthlyIncome(),
                        monthlyExpense: self.monthlyexpense(), // make sure casing matches your observable
                        balance: self.balance()
                    };

                    self.collection.create(newExpense, {
                        wait: true,
                        success: function () {
                            // use self here, not this
                            self.message(self.guestName() + " your expense details saved successfully");

                            alert(self.guestName() + " registered successfully");

                            // Optionally close dialog
                            // document.getElementById("addDialog").close();
                        },
                        error: function (model, xhr) {
                            console.error("Save failed", xhr);
                            alert("Failed to save expense: " + xhr.statusText);
                        }
                    });


                }

            }

            this.updateExpense = () => {
                console.log("Update Expense called ");
                this.message(this.guestName() + " your expense Details Updated successfully")

            }
        }
        return ExpenseFormViewModel;
    })