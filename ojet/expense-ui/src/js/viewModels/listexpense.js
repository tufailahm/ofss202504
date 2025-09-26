define(
    ['knockout',
        'ojs/ojrestdataprovider',
        'ojs/ojinputtext',
        'ojs/ojinputnumber',
        'ojs/ojformlayout',
        'ojs/ojtable',
    ],
    function (ko,RESTDataProvider) {
        function ListExpenseViewModel() {

            this.url = "http://localhost:9091/expense";
            this.dataprovider = ko.observable(null);

            this.loadExpense = () =>  {
                this.dataprovider = new RESTDataProvider.RESTDataProvider({
                    keyAttributes: this.keyAttributes,
                    url: this.url,
                    transforms: {
                        fetchFirst: {
                            request: async (options) => {
                                const url = new URL(options.url);
                                return new Request(url.href);
                            },
                            response: async ({ body }) => {
                                console.log("BODY :" + body);
                                return { data: body };
                            },
                        },
                    },
                });
                console.log("####Load visitor called :" + this.dataprovider)
            }

            this.loadExpense(); //onLoad
        }
        return ListExpenseViewModel;
    })