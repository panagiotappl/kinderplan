router.controller('navigationController', function($scope, $http, $cookies, UserService){
    $scope.user = {};
    // $scope.signedIn = {};
    // $scope.donotmatch = false;
    //
    // if($cookies.get('signedIn') == 'yes'){
    //     $scope.signedIn = true;
    //     $scope.token = $cookies.get('authToken');
    //     $scope.user.userId = $cookies.get('userId');
    // }else{
    //     $scope.signedIn = false;
    // }
    //
    // $scope.signin = function(user){
    //     UserService.singin(user)
    //         .then(function(response){
    //             console.log(response);
    //             UserService.getuser(response.data.userId)
    //                 .then(function(response){
    //                     $scope.signedIn = true;
    //                     $scope.user.email = response.data.email;
    //                 })
    //             $('#signin-modal').modal('hide');
    //
    //         }, function(error){
    //             console.log(error);
    //             $scope.donotmatch = true;
    //         });
    // }
    //
    // $scope.signout = function(){
    //     $cookies.remove('userId');
    //     $cookies.remove('generatedToken');
    //     $cookies.remove('role');
    //
    //     $cookies.put('signedIn', 'no');
    //     $scope.signedIn = false;
    //     $scope.user = {};
    //     $scope.signinform.$submitted = false;
    // }
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

        $http.get('api/userz').success(function(data) {
            // $http.get('api/user',JSON.stringify(user)).success(function(data) {
            console.log(data);
            if (data.name) {
                $scope.authenticated = true;
            } else {
                $scope.authenticated = false;
            }
        }).error(function() {
            $scope.authenticated = false;
        });

    };


});
