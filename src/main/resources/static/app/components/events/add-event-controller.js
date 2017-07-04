/**
 * Created by Panos on 20/05/2017.
 */

router.controller('addEventController', function($scope, $cookies, $state, $q, FilesService, EventsService){

    $scope.credentials = {
        provider: '',
        eventName: '',
        ageFrom: '',
        ageTo: '',
        ticketPrice: '',
        description: '',
        latitude: '',
        longitude: '',
        address: '',
        dates: [],
        photos: [],
        datesPicker: [{startDate: null, // TODO: Add today here
            endDate: null,  // TODO: And here
            availableTickets: 0
        }]
    };

    $scope.addNewDate = function() {
        $scope.credentials.datesPicker.push({startDate: null,
            endDate: null,
            availableTickets: 0
        });
    };

    $scope.removeDate = function() {
        var lastItem = $scope.credentials.datesPicker.length-1;
        $scope.credentials.datesPicker.splice(lastItem);
    };


    $scope.add = function(){
        $q.all($scope.upload()).then(function(resp) {
            resp.forEach(function(response) {
                $scope.credentials.photos.push(response.data.path);
            });
            var error = false;
            var miss_error = false;

            req = $scope.credentials;

            req.createdDate = new Date();
            req.address = $scope.geoloc;

            $scope.options = {
                types: 'geocode',
                watchEnter: true,
                country: 'gr'
            };

            if (error ||  miss_error) return;

            var address = $scope.details.geometry.location;

            req.latitude = address.lat();
            req.longitude = address.lng();

            var request = {
                provider: $cookies.get('id'),
                name: req.eventName,
                address: req.address,
                latitude: req.latitude,
                longitude: req.longitude,
                age_from: req.ageFrom,
                age_to: req.ageTo,
                ticket_price: req.ticketPrice,
                description: req.description,
                date_ending: 1495965135222, // TODO: Get first date from dates
                date_starting: 1495965135222, //TODO: Get last date from dates
                categories:[
                    {category: "sports"},
                    {category: "team"}
                ],
                dates: [],
                photos: req.photos
            };


            var all_dates = [];

            req.datesPicker.forEach( function (date)
            {

                var startDate = new Date(date.startDate._d).getTime();
                var endDate = new Date(date.endDate._d).getTime();

                all_dates.push(startDate);
                all_dates.push(endDate);

                request.dates.push({
                    start_date: startDate,
                    end_date: endDate,
                    available_tickets: date.availableTickets
                });
            });

            request.date_starting = Math.min.apply(null, all_dates);
            request.date_ending   = Math.max.apply(null, all_dates);


            console.log(request);
            EventsService.submitEvent(request, $cookies.get('authToken'))
                .then(function(response){
                    console.log(response);
                    $state.go('home');

                }, function(error){
                    $scope.error_message = error.data.message;
                    console.log($scope.error_message);

                });
        });



    };


    $scope.files = [];
    $scope.upload= function(){
        var files = $scope.files;
        console.log(files);

        var fileCount = files.length;

        var arr = [];


        for (var i = 0; i < fileCount; i++) {
            arr.push(FilesService.upload_file(files[i]));
        }

        return arr;
    };

});

