router.factory('FilesService', function($http) {
    var filesService = {};

    filesService.upload_file = function(file){
        var fd = new FormData();
        console.log(file);
        fd.append('file', file._file);
        var response = $http.post('/api/upload_image', fd, {
            transformRequest: angular.identity,
            headers: {'Content-Type': undefined}
        })
            .then(function(response){
                    console.log(response);
                    return response;
                });
        return response;


    };

    return filesService;
});