router.controller('homepageController', function($scope, $cookies, UserService){
    $scope.user = {}

    $scope.signin = function(user){
        UserService.singin(user)
            .then(function(response){
                console.log(repsonse.data);
            }, function(error){
                console.log(error);
            });
    }
});
