router.factory('UserService', function($http, $cookies) {
    var userService = {};

    userService.singin = function (user) {
        return $http.post('/api/login', user)
            .then(function (response) {
                $cookies.put('userId', response.data.userId);
                $cookies.put('generatedToken', response.data.generatedToken);
                $cookies.put('role', response.data.role);
                $cookies.put('signedIn', 'yes');
                return response.data;
            });

    };

    return userService;
});