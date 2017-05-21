module
    .controller('viewController', function($scope, $http, $location) {
        var path = $location.absUrl();
        var id = path.substring(path.lastIndexOf("=")+1);
        var string = "/good/"+id;
        $http.get(string.toString()).then(function (good) {
            $scope.good = good.data;
            var type_name = good.data.type.name;
            $http.get("/"+type_name+"/"+id).then(function (data) {
                var qualif = data.data;
                $scope.qualif = qualif;
            })
        }).catch(function (e) {
            var good = {"name":"something is wrong"};
            $scope.good = good;
        });

    });