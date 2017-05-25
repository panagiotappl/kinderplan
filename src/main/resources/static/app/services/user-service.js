router.factory('UserService', function($http, $cookies) {
    var userService = {};

    userService.singin = function (user) {
        var _authdata = btoa(user.email + ':' + user.password);
        $http.defaults.headers.common['Authorization'] = 'Basic ' + _authdata;
        return $http.post('/api/login')
            .then(function (response) {
                console.log(response);
                // $cookies.put('userId', response.data.userId);
                // $cookies.put('generatedToken', response.data.generatedToken);
                // $cookies.put('role', response.data.role);
                // $cookies.put('signedIn', 'yes');

                return response;
            });

    };

    userService.getuser = function(userId){
        return $http.get('/api/getuser/' + userId)
            .then(function(response){
                console.log(response);
                return response;
            });
    };

    return userService;
});