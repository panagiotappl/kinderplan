router.controller('homepageController', function($scope, $cookies, UserService){
    $scope.user = {}
    $scope.signedIn = {};
    $scope.donotmatch = false;


    if($cookies.get('signedIn') == 'yes'){
        $scope.signedIn = true;
        $scope.token = $cookies.get('authToken');
        $scope.user.userId = $cookies.get('userId');
    }else{
        $scope.signedIn = false;
    }

    $scope.signin = function(user){
        UserService.singin(user)
            .then(function(response){
                console.log(response);
                UserService.getuser(response.data.userId)
                    .then(function(response){
                        $scope.signedIn = true;
                        $scope.user.email = response.data.email;
                    })
                $('#signin-modal').modal('hide');

            }, function(error){
                $scope.donotmatch = true;
            });
    }

    $scope.signout = function(){
        $cookies.remove('userId');
        $cookies.remove('generatedToken');
        $cookies.remove('role');

        $cookies.put('signedIn', 'no');
        $scope.signedIn = false;
        $scope.user = {};
        $scope.signinform.$submitted = false;
    }
});
