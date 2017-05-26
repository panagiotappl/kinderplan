router.controller('navigationController', function($scope, $http, $cookies, UserService){
    $scope.user = {};
    $scope.signedIn = {};
    $scope.donotmatch = false;

    if($cookies.get('signedIn') === 'yes'){
        $scope.signedIn = true;
        $scope.user.userId = $cookies.get('id');
        UserService.getuser()
            .then(function(response){
                $scope.user.email = response.data.email;
                $scope.user.name = response.data.name;
            }, function(response){
                console.log(response);
            });
    }else{
        $scope.signedIn = false;
    }

    $scope.signout = function(){
        $cookies.remove('id');
        $cookies.remove('role');

        $cookies.put('signedIn', 'no');
        $scope.signedIn = false;
        $scope.user = {};
        $scope.signinform.$submitted = false;
        $http.defaults.headers.common['Authorization'] = '';
    }
    $scope.signin = function(user){

        // var headers = user ? {authorization : "Basic "
        // + btoa(user.email + ":" + user.password)
        // } : {};
        // console.log(headers);
        // console.log(user);
        // console.log(JSON.stringify(user));

        // var _authdata = Base64.encode('john123' + ':' + 'password');
        // console.log(user);
        // console.log(_authdata);
        // var _headers = {
        //     'Authorization': 'Basic ' + _authdata,
        //     'Content-Type': 'application/json; charset=utf-8'
        // };
        // console.log(_headers);
        //

        var _authdata = btoa(user.email + ':' + user.password);
        $http.defaults.headers.common['Authorization'] = 'Basic ' + _authdata;
        // $http.defaults.headers.post['Content-Type'] = 'application/json';

        UserService.singin(user)
            .then(function(response){
                UserService.getuser()
                    .then(function(response){
                        $scope.signedIn = true;
                        $scope.user.email = response.data.email;
                        $scope.user.name = response.data.name;

                    }, function(response){
                        console.log(response);
                    });


                $('#signin-modal').modal('hide');

            }, function(error){
                console.log(error);
                $scope.donotmatch = true;
            });


    };


});
