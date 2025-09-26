define(['ojs/ojmodel', 'models/ExpenseModel'], function (oj, ExpenseModel) {
    var ExpenseCollection = oj.Collection.extend({
        url: 'http://localhost:9091/expense',
        model: ExpenseModel
    });
    return ExpenseCollection;
});
