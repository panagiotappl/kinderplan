
router.controller('providerSignupController', function($scope, $cookies, UserService){

    $scope.credentials = {
        company_name: '',
        email: '',
        password: '',
        rep_password: '',
        first_name: '',
        last_name: '',
        phone_number: '',
        latitude: '',
        longitude: '',
        address: '',
        role: '',
        afm: ''
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
            role: 'provider',
            name: $scope.credentials.first_name,
            surname: $scope.credentials.last_name,
            phone: $scope.credentials.phone_number,
            latitude: $scope.credentials.latitude,
            longitude: $scope.credentials.longitude,
            address: $scope.geoloc,
            provider: {
                companyName: $scope.credentials.company_name,
                vatNumber: $scope.credentials.afm
            }
        };

        var address = $scope.details.geometry.location;

        request.latitude = address.lat();
        request.longitude = address.lng();

        console.log(request);

        UserService.createUser(request)
            .then(function(response){
                console.log(response)

            }, function(error){
                console.log(error);
            });


    }
});