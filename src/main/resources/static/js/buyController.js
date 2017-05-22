/**
 * Created by Administrator on 21.05.2017.
 */

module
    .controller('buyController', function ($scope, $http, $location) {
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
            $http.post('/order', order).then(alert("Success"))

        }

    });