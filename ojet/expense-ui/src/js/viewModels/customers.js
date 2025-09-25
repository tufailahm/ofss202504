define(
  [
    'knockout',
    'ojs/ojinputtext',
    'ojs/ojbutton',
    'ojs/ojselectsingle',
             'ojs/ojarraydataprovider'
  ],
  function (ko,InputText, Button, SelectSingle, ArrayDataProvider) {
    function CustomerViewModel() {
      this.username = ko.observable("aish123");
      this.firstName = ko.observable("Aishwarya");
      this.lastName = ko.observable("Rai")
      this.customerType = [
        { value: 'O', label: 'Permanent' },
        { value: 'C', label: 'Contractual' },
        { value: 'F', label: 'Freelance' },
        { value: 'V', label: 'Vendor' }
      ];

      this.dataProvider = new ArrayDataProvider(this.customerType,{
              keyAttributes: 'value'

      })

      this.selectVal = 'F';
    }
    return CustomerViewModel;
  })