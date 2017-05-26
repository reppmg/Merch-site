/**
 * Created by Administrator on 21.05.2017.
 */

module
    .controller('buyController', function ($scope, $http, $location, sharedProperties) {

        $scope.useSavedAddress = true;
        $scope.useSavedEmail = true;
        $scope.useSavedPhone = true;

        $scope.changeUsingSavedPhone = function () {
            $scope.useSavedPhone = !$scope.useSavedPhone;
        };
        $scope.changeUsingSavedEmail = function () {
            $scope.useSavedEmail = !$scope.useSavedEmail;
        };
        $scope.changeUsingSavedAddress = function () {
            $scope.useSavedAddress = !$scope.useSavedAddress;
        };

        $http.get('/user').then(function (data) {
            $scope.phone = data.data.phone;
            $scope.email = data.data.email;
            $scope.address = data.data.address.zip +
                " " +
                data.data.address.street +
                " " +
                data.data.address.rest;
        });

        var path = $location.absUrl();
        var id = path.substring(path.lastIndexOf("=") + 1);
        var string = "/good/" + id;
        var type_name;
        $http.get(string.toString()).then(function (good) {
            $scope.good = good.data;
            type_name = good.data.type.name;
            $scope.type_name = type_name;
            $http.get("/" + type_name + "/" + id).then(function (data) {
                var qualif = data.data;
                $scope.qualif = qualif;
            })
        }).catch(function (e) {
            var good = {"name": "something is wrong"};
            $scope.good = good;
        });

        // $scope.qualif = qualif;

        function convertFormToJSON(form, good_id, email) {
            var array = jQuery(form).serializeArray();
            var json = {};
            json["good_id"] = good_id;
            json["email"] = email;
            json["address"] = {};
            var goodFields = ['zip', 'street', 'rest'];
            jQuery.each(array, function () {
                if (goodFields.indexOf(this.name) !== -1) {
                    json["address"][this.name] = this.value || ''
                } else {
                    json[this.name] = this.value || '';
                }
            });
            return json;
        }

        $scope.post = function () {
            var s = $("#buyGood");
            var order = convertFormToJSON(s, id);
            order["user_id"] = sharedProperties.getProperty();
            if ($scope.useSavedPhone) order["phone"] = null;
            if ($scope.useSavedEmail) order["email"] = null;
            if ($scope.useSavedAddress) order["address"] = null;
            $http.post('/order', order).then(alert("Success"))

        }


    });