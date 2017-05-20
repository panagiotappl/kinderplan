/**
 * Created by Panos on 20/05/2017.
 */

router.controller('addEventController', function($scope, $cookies, UserService){

    $scope.credentials = {
        provider: '',
        event_name: '',
        age_from: '',
        age_to: '',
        ticket_price: '',
        description: '',
        latitude: '',
        longitude: '',
        address: '',
        startDate: null,
        endDate: null,
        dates: []

    };

    $scope.add = function(){
        var error = false;
        var miss_error = false;

        $scope.options = {
            types: 'geocode',
            watchEnter: true,
            country: 'gr'
        };

        if (error ||  miss_error) return;

        var request = {
            provider: '', //TODO: get this from the cookie!
            event_name: $scope.credentials.event_name,
            age_from: $scope.credentials.age_from,
            age_to: $scope.credentials.age_to,
            ticket_price: $scope.credentials.ticket_price,
            description: $scope.credentials.description,
            latitude: $scope.credentials.latitude,
            longitude: $scope.credentials.longitude,
            address: $scope.geoloc,
            dates : $scope.credentials.dates,
            startDate: null,
            endDate: null
        };

        var address = $scope.details.geometry.location;

        request.latitude = address.lat();
        request.longitude = address.lng();

        console.log(request)

    }

});

