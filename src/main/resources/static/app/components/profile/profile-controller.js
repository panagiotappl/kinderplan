router.controller('profileController', function($scope, $cookies, $state, UserService){
    $scope.user = {};
    $scope.parent = false;
    $scope.provider = false;


    if($cookies.get('signedIn') === 'yes'){
        $scope.signedIn = true;
        $scope.user.userId = $cookies.get('id');
        $scope.user.authToken = $cookies.get('authToken');

        UserService.getuser($scope.user.userId ,$scope.user.authToken)
            .then(function(response){
                $scope.user = response.data;
                console.log($scope.user);
                if($scope.user.parentDto != null)
                    $scope.parent = true;
                else
                    $scope.provider = true;
            }, function(response){
                $scope.signedIn = false;
            });
    }else{
        $state.go('notValid');
    }
});