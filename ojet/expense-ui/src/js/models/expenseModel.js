define(['ojs/ojmodel'], function (oj) {
    var ExpenseModel = oj.Model.extend({
        idAttribute: 'guestId',
        urlRoot: 'http://localhost:9091/expense'
    });
    return ExpenseModel;
});
