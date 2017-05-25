router.controller('homepageController', function($scope, $cookies, UserService){
    $scope.items = ["Any Day", "Monday", "Tuesday", "Thursday", "Wednesday", "Friday", "Saturday", "Sunday"];
    $scope.selected = [];

    $scope.toggle = function (item, list) {
        var idx = list.indexOf(item);
        if (idx > -1) {
            list.splice(idx, 1);
        }
        else {
            list.push(item);
        }
    };

    $scope.exists = function (item, list) {
        return list.indexOf(item) > -1;
    };
});
