
router.controller('parentSignupController', function($scope, $cookies, $state, UserService){

    $scope.error_message = null;
    $scope.credentials = {
        email: '',
        password: '',
        rep_password: '',
        first_name: '',
        last_name: '',
        phone_number: '',
        latitude: '',
        longitude: '',
        address: '',
        role: ''
    };


    $scope.signup = function() {

        $scope.options = {
            types: 'geocode',
            watchEnter: true,
            country: 'gr'
        };


        var request = {
            email: $scope.credentials.email,
            password: $scope.credentials.password,
            repassword: $scope.credentials.rep_password,
            role: 'parent',
            name: $scope.credentials.first_name,
            surname: $scope.credentials.last_name,
            phone: $scope.credentials.phone_number,
            latitude: $scope.credentials.latitude,
            longitude: $scope.credentials.longitude,
            address: $scope.geoloc,
            parent: {
                points: 0
            }
        };

        var address = $scope.details.geometry.location;

        request.latitude = address.lat();
        request.longitude = address.lng();

        console.log(request);

        UserService.createUser(request)
            .then(function(response){
                console.log(response);
                $state.go('home');

            }, function(error){
                $scope.error_message = error.data.message;
                console.log($scope.error_message);

            });


    }
});