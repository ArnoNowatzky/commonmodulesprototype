(function () {
  function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

  function _defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } }

  function _createClass(Constructor, protoProps, staticProps) { if (protoProps) _defineProperties(Constructor.prototype, protoProps); if (staticProps) _defineProperties(Constructor, staticProps); return Constructor; }

  (window["webpackJsonp"] = window["webpackJsonp"] || []).push([["main"], {
    /***/
    0:
    /*!***************************!*\
      !*** multi ./src/main.ts ***!
      \***************************/

    /*! no static exports found */

    /***/
    function _(module, exports, __webpack_require__) {
      module.exports = __webpack_require__(
      /*! /Users/OleyMa/vcs/wawiNeu/commonmodulesprototype/commonModuleExample/src/main.ts */
      "zUnb");
      /***/
    },

    /***/
    "AytR":
    /*!*****************************************!*\
      !*** ./src/environments/environment.ts ***!
      \*****************************************/

    /*! exports provided: environment */

    /***/
    function AytR(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */


      __webpack_require__.d(__webpack_exports__, "environment", function () {
        return environment;
      }); // This file can be replaced during build by using the `fileReplacements` array.
      // `ng build --prod` replaces `environment.ts` with `environment.prod.ts`.
      // The list of file replacements can be found in `angular.json`.


      var environment = {
        production: false,
        API_BASE_PATH_CM: "https://localhost:8002",
        API_BASE_PATH_WAWI: "https://localhost:8003"
      };
      /*
       * For easier debugging in development mode, you can import the following file
       * to ignore zone related error stack frames such as `zone.run`, `zoneDelegate.invokeTask`.
       *
       * This import should be commented out in production mode because it will have a negative impact
       * on performance if an error is thrown.
       */
      // import 'zone.js/dist/zone-error';  // Included with Angular CLI.

      /***/
    },

    /***/
    "Cfsl":
    /*!******************************************!*\
      !*** ./src/app/generatedWawi/encoder.ts ***!
      \******************************************/

    /*! exports provided: CustomHttpParameterCodec */

    /***/
    function Cfsl(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */


      __webpack_require__.d(__webpack_exports__, "CustomHttpParameterCodec", function () {
        return CustomHttpParameterCodec;
      });
      /**
       * Custom HttpParameterCodec
       * Workaround for https://github.com/angular/angular/issues/18261
       */


      var CustomHttpParameterCodec = /*#__PURE__*/function () {
        function CustomHttpParameterCodec() {
          _classCallCheck(this, CustomHttpParameterCodec);
        }

        _createClass(CustomHttpParameterCodec, [{
          key: "encodeKey",
          value: function encodeKey(k) {
            return encodeURIComponent(k);
          }
        }, {
          key: "encodeValue",
          value: function encodeValue(v) {
            return encodeURIComponent(v);
          }
        }, {
          key: "decodeKey",
          value: function decodeKey(k) {
            return decodeURIComponent(k);
          }
        }, {
          key: "decodeValue",
          value: function decodeValue(v) {
            return decodeURIComponent(v);
          }
        }]);

        return CustomHttpParameterCodec;
      }();
      /***/

    },

    /***/
    "DzCe":
    /*!******************************************!*\
      !*** ./src/app/generatedCm/variables.ts ***!
      \******************************************/

    /*! exports provided: BASE_PATH, COLLECTION_FORMATS */

    /***/
    function DzCe(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */


      __webpack_require__.d(__webpack_exports__, "BASE_PATH", function () {
        return BASE_PATH;
      });
      /* harmony export (binding) */


      __webpack_require__.d(__webpack_exports__, "COLLECTION_FORMATS", function () {
        return COLLECTION_FORMATS;
      });
      /* harmony import */


      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(
      /*! @angular/core */
      "fXoL");

      var BASE_PATH = new _angular_core__WEBPACK_IMPORTED_MODULE_0__["InjectionToken"]('basePath');
      var COLLECTION_FORMATS = {
        'csv': ',',
        'tsv': '   ',
        'ssv': ' ',
        'pipes': '|'
      };
      /***/
    },

    /***/
    "ENP6":
    /*!*************************************************************!*\
      !*** ./src/app/generatedCm/model/medicationcontainerDTO.ts ***!
      \*************************************************************/

    /*! no exports provided */

    /***/
    function ENP6(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /***/

    },

    /***/
    "KVkJ":
    /*!***********************************************!*\
      !*** ./src/app/generatedWawi/model/models.ts ***!
      \***********************************************/

    /*! no exports provided */

    /***/
    function KVkJ(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony import */


      var _pharmacyDTO__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(
      /*! ./pharmacyDTO */
      "THpc");
      /* empty/unused harmony star reexport */

      /***/

    },

    /***/
    "Mvny":
    /*!****************************************************!*\
      !*** ./src/app/generatedCm/model/medicationDTO.ts ***!
      \****************************************************/

    /*! no exports provided */

    /***/
    function Mvny(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /**
       * medication plans api
       * API of service example medication plans
       *
       * The version of the OpenAPI document: 1.0.0
       *
       *
       * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
       * https://openapi-generator.tech
       * Do not edit the class manually.
       */

      /***/

    },

    /***/
    "OoPK":
    /*!*******************************************************!*\
      !*** ./src/app/generatedWawi/api/pharmacy.service.ts ***!
      \*******************************************************/

    /*! exports provided: PharmacyService */

    /***/
    function OoPK(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */


      __webpack_require__.d(__webpack_exports__, "PharmacyService", function () {
        return PharmacyService;
      });
      /* harmony import */


      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(
      /*! @angular/core */
      "fXoL");
      /* harmony import */


      var _angular_common_http__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(
      /*! @angular/common/http */
      "tk/3");
      /* harmony import */


      var _encoder__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(
      /*! ../encoder */
      "Cfsl");
      /* harmony import */


      var _variables__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(
      /*! ../variables */
      "wsM+");
      /* harmony import */


      var _configuration__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(
      /*! ../configuration */
      "PFOZ");
      /**
       * WAWI api
       * API of WAWI
       *
       * The version of the OpenAPI document: 1.0.0
       *
       *
       * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
       * https://openapi-generator.tech
       * Do not edit the class manually.
       */

      /* tslint:disable:no-unused-variable member-ordering */


      var PharmacyService = /*#__PURE__*/function () {
        function PharmacyService(httpClient, basePath, configuration) {
          _classCallCheck(this, PharmacyService);

          this.httpClient = httpClient;
          this.basePath = 'http://localhost:8003/v1';
          this.defaultHeaders = new _angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpHeaders"]();
          this.configuration = new _configuration__WEBPACK_IMPORTED_MODULE_4__["Configuration"]();

          if (configuration) {
            this.configuration = configuration;
          }

          if (typeof this.configuration.basePath !== 'string') {
            if (typeof basePath !== 'string') {
              basePath = this.basePath;
            }

            this.configuration.basePath = basePath;
          }

          this.encoder = this.configuration.encoder || new _encoder__WEBPACK_IMPORTED_MODULE_2__["CustomHttpParameterCodec"]();
        }

        _createClass(PharmacyService, [{
          key: "addToHttpParams",
          value: function addToHttpParams(httpParams, value, key) {
            if (typeof value === "object" && value instanceof Date === false) {
              httpParams = this.addToHttpParamsRecursive(httpParams, value);
            } else {
              httpParams = this.addToHttpParamsRecursive(httpParams, value, key);
            }

            return httpParams;
          }
        }, {
          key: "addToHttpParamsRecursive",
          value: function addToHttpParamsRecursive(httpParams, value, key) {
            var _this = this;

            if (value == null) {
              return httpParams;
            }

            if (typeof value === "object") {
              if (Array.isArray(value)) {
                value.forEach(function (elem) {
                  return httpParams = _this.addToHttpParamsRecursive(httpParams, elem, key);
                });
              } else if (value instanceof Date) {
                if (key != null) {
                  httpParams = httpParams.append(key, value.toISOString().substr(0, 10));
                } else {
                  throw Error("key may not be null if value is Date");
                }
              } else {
                Object.keys(value).forEach(function (k) {
                  return httpParams = _this.addToHttpParamsRecursive(httpParams, value[k], key != null ? "".concat(key, ".").concat(k) : k);
                });
              }
            } else if (key != null) {
              httpParams = httpParams.append(key, value);
            } else {
              throw Error("key may not be null if value is not object or array");
            }

            return httpParams;
          }
        }, {
          key: "getPharmacyInfo",
          value: function getPharmacyInfo() {
            var observe = arguments.length > 0 && arguments[0] !== undefined ? arguments[0] : 'body';
            var reportProgress = arguments.length > 1 && arguments[1] !== undefined ? arguments[1] : false;
            var options = arguments.length > 2 ? arguments[2] : undefined;
            var headers = this.defaultHeaders;
            var httpHeaderAcceptSelected = options && options.httpHeaderAccept;

            if (httpHeaderAcceptSelected === undefined) {
              // to determine the Accept header
              var httpHeaderAccepts = ['application/json'];
              httpHeaderAcceptSelected = this.configuration.selectHeaderAccept(httpHeaderAccepts);
            }

            if (httpHeaderAcceptSelected !== undefined) {
              headers = headers.set('Accept', httpHeaderAcceptSelected);
            }

            var responseType = 'json';

            if (httpHeaderAcceptSelected && httpHeaderAcceptSelected.startsWith('text')) {
              responseType = 'text';
            }

            return this.httpClient.get("".concat(this.configuration.basePath, "/pharmacy"), {
              responseType: responseType,
              withCredentials: this.configuration.withCredentials,
              headers: headers,
              observe: observe,
              reportProgress: reportProgress
            });
          }
        }]);

        return PharmacyService;
      }();

      PharmacyService.ɵfac = function PharmacyService_Factory(t) {
        return new (t || PharmacyService)(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵinject"](_angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpClient"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵinject"](_variables__WEBPACK_IMPORTED_MODULE_3__["BASE_PATH"], 8), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵinject"](_configuration__WEBPACK_IMPORTED_MODULE_4__["Configuration"], 8));
      };

      PharmacyService.ɵprov = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjectable"]({
        token: PharmacyService,
        factory: PharmacyService.ɵfac,
        providedIn: 'root'
      });
      /*@__PURE__*/

      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](PharmacyService, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Injectable"],
          args: [{
            providedIn: 'root'
          }]
        }], function () {
          return [{
            type: _angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpClient"]
          }, {
            type: undefined,
            decorators: [{
              type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Optional"]
            }, {
              type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Inject"],
              args: [_variables__WEBPACK_IMPORTED_MODULE_3__["BASE_PATH"]]
            }]
          }, {
            type: _configuration__WEBPACK_IMPORTED_MODULE_4__["Configuration"],
            decorators: [{
              type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Optional"]
            }]
          }];
        }, null);
      })();
      /***/

    },

    /***/
    "PFOZ":
    /*!************************************************!*\
      !*** ./src/app/generatedWawi/configuration.ts ***!
      \************************************************/

    /*! exports provided: Configuration */

    /***/
    function PFOZ(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */


      __webpack_require__.d(__webpack_exports__, "Configuration", function () {
        return Configuration;
      });

      var Configuration = /*#__PURE__*/function () {
        function Configuration() {
          var configurationParameters = arguments.length > 0 && arguments[0] !== undefined ? arguments[0] : {};

          _classCallCheck(this, Configuration);

          this.apiKeys = configurationParameters.apiKeys;
          this.username = configurationParameters.username;
          this.password = configurationParameters.password;
          this.accessToken = configurationParameters.accessToken;
          this.basePath = configurationParameters.basePath;
          this.withCredentials = configurationParameters.withCredentials;
          this.encoder = configurationParameters.encoder;
        }
        /**
         * Select the correct content-type to use for a request.
         * Uses {@link Configuration#isJsonMime} to determine the correct content-type.
         * If no content type is found return the first found type if the contentTypes is not empty
         * @param contentTypes - the array of content types that are available for selection
         * @returns the selected content-type or <code>undefined</code> if no selection could be made.
         */


        _createClass(Configuration, [{
          key: "selectHeaderContentType",
          value: function selectHeaderContentType(contentTypes) {
            var _this2 = this;

            if (contentTypes.length === 0) {
              return undefined;
            }

            var type = contentTypes.find(function (x) {
              return _this2.isJsonMime(x);
            });

            if (type === undefined) {
              return contentTypes[0];
            }

            return type;
          }
          /**
           * Select the correct accept content-type to use for a request.
           * Uses {@link Configuration#isJsonMime} to determine the correct accept content-type.
           * If no content type is found return the first found type if the contentTypes is not empty
           * @param accepts - the array of content types that are available for selection.
           * @returns the selected content-type or <code>undefined</code> if no selection could be made.
           */

        }, {
          key: "selectHeaderAccept",
          value: function selectHeaderAccept(accepts) {
            var _this3 = this;

            if (accepts.length === 0) {
              return undefined;
            }

            var type = accepts.find(function (x) {
              return _this3.isJsonMime(x);
            });

            if (type === undefined) {
              return accepts[0];
            }

            return type;
          }
          /**
           * Check if the given MIME is a JSON MIME.
           * JSON MIME examples:
           *   application/json
           *   application/json; charset=UTF8
           *   APPLICATION/JSON
           *   application/vnd.company+json
           * @param mime - MIME (Multipurpose Internet Mail Extensions)
           * @return True if the given MIME is JSON, false otherwise.
           */

        }, {
          key: "isJsonMime",
          value: function isJsonMime(mime) {
            var jsonMime = new RegExp('^(application\/json|[^;/ \t]+\/[^;/ \t]+[+]json)[ \t]*(;.*)?$', 'i');
            return mime !== null && (jsonMime.test(mime) || mime.toLowerCase() === 'application/json-patch+json');
          }
        }]);

        return Configuration;
      }();
      /***/

    },

    /***/
    "PRdS":
    /*!*********************************************!*\
      !*** ./src/app/generatedCm/model/models.ts ***!
      \*********************************************/

    /*! no exports provided */

    /***/
    function PRdS(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony import */


      var _medicationDTO__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(
      /*! ./medicationDTO */
      "Mvny");
      /* empty/unused harmony star reexport */

      /* harmony import */


      var _medicationcontainerDTO__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(
      /*! ./medicationcontainerDTO */
      "ENP6");
      /* empty/unused harmony star reexport */

      /***/

    },

    /***/
    "PxCJ":
    /*!****************************************!*\
      !*** ./src/app/generatedCm/encoder.ts ***!
      \****************************************/

    /*! exports provided: CustomHttpParameterCodec */

    /***/
    function PxCJ(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */


      __webpack_require__.d(__webpack_exports__, "CustomHttpParameterCodec", function () {
        return CustomHttpParameterCodec;
      });
      /**
       * Custom HttpParameterCodec
       * Workaround for https://github.com/angular/angular/issues/18261
       */


      var CustomHttpParameterCodec = /*#__PURE__*/function () {
        function CustomHttpParameterCodec() {
          _classCallCheck(this, CustomHttpParameterCodec);
        }

        _createClass(CustomHttpParameterCodec, [{
          key: "encodeKey",
          value: function encodeKey(k) {
            return encodeURIComponent(k);
          }
        }, {
          key: "encodeValue",
          value: function encodeValue(v) {
            return encodeURIComponent(v);
          }
        }, {
          key: "decodeKey",
          value: function decodeKey(k) {
            return decodeURIComponent(k);
          }
        }, {
          key: "decodeValue",
          value: function decodeValue(v) {
            return decodeURIComponent(v);
          }
        }]);

        return CustomHttpParameterCodec;
      }();
      /***/

    },

    /***/
    "Sy1n":
    /*!**********************************!*\
      !*** ./src/app/app.component.ts ***!
      \**********************************/

    /*! exports provided: AppComponent */

    /***/
    function Sy1n(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */


      __webpack_require__.d(__webpack_exports__, "AppComponent", function () {
        return AppComponent;
      });
      /* harmony import */


      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(
      /*! @angular/core */
      "fXoL");
      /* harmony import */


      var _generatedCm__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(
      /*! ./generatedCm */
      "T01Q");
      /* harmony import */


      var _generatedWawi__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(
      /*! ./generatedWawi */
      "UyeY");
      /* harmony import */


      var _angular_common__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(
      /*! @angular/common */
      "ofXK");

      function AppComponent_div_7_tr_12_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "tr");

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "td");

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2);

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](3, "td");

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](4);

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](5, "td");

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](6);

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }

        if (rf & 2) {
          var medication_r2 = ctx.$implicit;

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](medication_r2.id);

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](medication_r2.consumerName);

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](medication_r2.consumerFirstname);
        }
      }

      function AppComponent_div_7_Template(rf, ctx) {
        if (rf & 1) {
          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "div");

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "h2");

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2, "Data from own CM");

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](3, "table");

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](4, "thead");

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](5, "th");

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](6, "ID");

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](7, "th");

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](8, "Name");

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](9, "th");

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](10, "First name");

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](11, "tbody");

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](12, AppComponent_div_7_tr_12_Template, 7, 3, "tr", 1);

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        }

        if (rf & 2) {
          var ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"]();

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](12);

          _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngForOf", ctx_r0.medicationContainers);
        }
      }

      var AppComponent = function AppComponent(medicationsService, pharmacyService) {
        var _this4 = this;

        _classCallCheck(this, AppComponent);

        this.medicationsService = medicationsService;
        this.pharmacyService = pharmacyService;
        this.title = 'client';
        this.displayedColumns = ['id', 'name'];
        this.medicationContainers = [];
        this.pharmacyInfo = {};
        console.log("Call medicationcontainers");
        this.medicationsService.getMedicationContainers().subscribe(function (x) {
          return _this4.medicationContainers = x;
        }, function (err) {
          return console.error('Observer got an error: ' + err.message);
        }, function () {
          return console.error('Observer finished');
        });
        console.log("Call pharmacyinfos");
        this.pharmacyService.getPharmacyInfo().subscribe(function (x) {
          return _this4.pharmacyInfo = x;
        }, function (err) {
          return console.error('Observer got an error: ' + err.message);
        }, function () {
          return console.error('Observer finished');
        });
      };

      AppComponent.ɵfac = function AppComponent_Factory(t) {
        return new (t || AppComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_generatedCm__WEBPACK_IMPORTED_MODULE_1__["MedicationsService"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_generatedWawi__WEBPACK_IMPORTED_MODULE_2__["PharmacyService"]));
      };

      AppComponent.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({
        type: AppComponent,
        selectors: [["app-root"]],
        decls: 8,
        vars: 2,
        consts: [[4, "ngIf"], [4, "ngFor", "ngForOf"]],
        template: function AppComponent_Template(rf, ctx) {
          if (rf & 1) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](0, "TODO migrate from material to primeng ");

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](1, "br");

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](2, "br");

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](3, "h2");

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](4, "Data from WAWI");

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](5);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](6, "br");

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](7, AppComponent_div_7_Template, 13, 1, "div", 0);
          }

          if (rf & 2) {
            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](5);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"]("\nPharmacyname: '", ctx.pharmacyInfo.name, "' ");

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);

            _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngIf", ctx.medicationContainers);
          }
        },
        directives: [_angular_common__WEBPACK_IMPORTED_MODULE_3__["NgIf"], _angular_common__WEBPACK_IMPORTED_MODULE_3__["NgForOf"]],
        styles: ["\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJhcHAuY29tcG9uZW50LmNzcyJ9 */"]
      });
      /*@__PURE__*/

      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](AppComponent, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
          args: [{
            selector: 'app-root',
            templateUrl: './app.component.html',
            styleUrls: ['./app.component.css']
          }]
        }], function () {
          return [{
            type: _generatedCm__WEBPACK_IMPORTED_MODULE_1__["MedicationsService"]
          }, {
            type: _generatedWawi__WEBPACK_IMPORTED_MODULE_2__["PharmacyService"]
          }];
        }, null);
      })();
      /***/

    },

    /***/
    "T01Q":
    /*!**************************************!*\
      !*** ./src/app/generatedCm/index.ts ***!
      \**************************************/

    /*! exports provided: MedicationsService, APIS, BASE_PATH, COLLECTION_FORMATS, Configuration, ApiModule */

    /***/
    function T01Q(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony import */


      var _api_api__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(
      /*! ./api/api */
      "el7H");
      /* harmony reexport (safe) */


      __webpack_require__.d(__webpack_exports__, "MedicationsService", function () {
        return _api_api__WEBPACK_IMPORTED_MODULE_0__["MedicationsService"];
      });
      /* harmony reexport (safe) */


      __webpack_require__.d(__webpack_exports__, "APIS", function () {
        return _api_api__WEBPACK_IMPORTED_MODULE_0__["APIS"];
      });
      /* harmony import */


      var _model_models__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(
      /*! ./model/models */
      "PRdS");
      /* empty/unused harmony star reexport */

      /* harmony import */


      var _variables__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(
      /*! ./variables */
      "DzCe");
      /* harmony reexport (safe) */


      __webpack_require__.d(__webpack_exports__, "BASE_PATH", function () {
        return _variables__WEBPACK_IMPORTED_MODULE_2__["BASE_PATH"];
      });
      /* harmony reexport (safe) */


      __webpack_require__.d(__webpack_exports__, "COLLECTION_FORMATS", function () {
        return _variables__WEBPACK_IMPORTED_MODULE_2__["COLLECTION_FORMATS"];
      });
      /* harmony import */


      var _configuration__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(
      /*! ./configuration */
      "bqOV");
      /* harmony reexport (safe) */


      __webpack_require__.d(__webpack_exports__, "Configuration", function () {
        return _configuration__WEBPACK_IMPORTED_MODULE_3__["Configuration"];
      });
      /* harmony import */


      var _api_module__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(
      /*! ./api.module */
      "z8r5");
      /* harmony reexport (safe) */


      __webpack_require__.d(__webpack_exports__, "ApiModule", function () {
        return _api_module__WEBPACK_IMPORTED_MODULE_4__["ApiModule"];
      });
      /***/

    },

    /***/
    "T0NR":
    /*!********************************************************!*\
      !*** ./src/app/generatedCm/api/medications.service.ts ***!
      \********************************************************/

    /*! exports provided: MedicationsService */

    /***/
    function T0NR(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */


      __webpack_require__.d(__webpack_exports__, "MedicationsService", function () {
        return MedicationsService;
      });
      /* harmony import */


      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(
      /*! @angular/core */
      "fXoL");
      /* harmony import */


      var _angular_common_http__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(
      /*! @angular/common/http */
      "tk/3");
      /* harmony import */


      var _encoder__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(
      /*! ../encoder */
      "PxCJ");
      /* harmony import */


      var _variables__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(
      /*! ../variables */
      "DzCe");
      /* harmony import */


      var _configuration__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(
      /*! ../configuration */
      "bqOV");
      /**
       * medication plans api
       * API of service example medication plans
       *
       * The version of the OpenAPI document: 1.0.0
       *
       *
       * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
       * https://openapi-generator.tech
       * Do not edit the class manually.
       */

      /* tslint:disable:no-unused-variable member-ordering */


      var MedicationsService = /*#__PURE__*/function () {
        function MedicationsService(httpClient, basePath, configuration) {
          _classCallCheck(this, MedicationsService);

          this.httpClient = httpClient;
          this.basePath = 'http://localhost:8002/v1';
          this.defaultHeaders = new _angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpHeaders"]();
          this.configuration = new _configuration__WEBPACK_IMPORTED_MODULE_4__["Configuration"]();

          if (configuration) {
            this.configuration = configuration;
          }

          if (typeof this.configuration.basePath !== 'string') {
            if (typeof basePath !== 'string') {
              basePath = this.basePath;
            }

            this.configuration.basePath = basePath;
          }

          this.encoder = this.configuration.encoder || new _encoder__WEBPACK_IMPORTED_MODULE_2__["CustomHttpParameterCodec"]();
        }

        _createClass(MedicationsService, [{
          key: "addToHttpParams",
          value: function addToHttpParams(httpParams, value, key) {
            if (typeof value === "object" && value instanceof Date === false) {
              httpParams = this.addToHttpParamsRecursive(httpParams, value);
            } else {
              httpParams = this.addToHttpParamsRecursive(httpParams, value, key);
            }

            return httpParams;
          }
        }, {
          key: "addToHttpParamsRecursive",
          value: function addToHttpParamsRecursive(httpParams, value, key) {
            var _this5 = this;

            if (value == null) {
              return httpParams;
            }

            if (typeof value === "object") {
              if (Array.isArray(value)) {
                value.forEach(function (elem) {
                  return httpParams = _this5.addToHttpParamsRecursive(httpParams, elem, key);
                });
              } else if (value instanceof Date) {
                if (key != null) {
                  httpParams = httpParams.append(key, value.toISOString().substr(0, 10));
                } else {
                  throw Error("key may not be null if value is Date");
                }
              } else {
                Object.keys(value).forEach(function (k) {
                  return httpParams = _this5.addToHttpParamsRecursive(httpParams, value[k], key != null ? "".concat(key, ".").concat(k) : k);
                });
              }
            } else if (key != null) {
              httpParams = httpParams.append(key, value);
            } else {
              throw Error("key may not be null if value is not object or array");
            }

            return httpParams;
          }
        }, {
          key: "findMedicationContainersByConsumer",
          value: function findMedicationContainersByConsumer(consumerId) {
            var observe = arguments.length > 1 && arguments[1] !== undefined ? arguments[1] : 'body';
            var reportProgress = arguments.length > 2 && arguments[2] !== undefined ? arguments[2] : false;
            var options = arguments.length > 3 ? arguments[3] : undefined;

            if (consumerId === null || consumerId === undefined) {
              throw new Error('Required parameter consumerId was null or undefined when calling findMedicationContainersByConsumer.');
            }

            var headers = this.defaultHeaders;
            var httpHeaderAcceptSelected = options && options.httpHeaderAccept;

            if (httpHeaderAcceptSelected === undefined) {
              // to determine the Accept header
              var httpHeaderAccepts = ['application/json'];
              httpHeaderAcceptSelected = this.configuration.selectHeaderAccept(httpHeaderAccepts);
            }

            if (httpHeaderAcceptSelected !== undefined) {
              headers = headers.set('Accept', httpHeaderAcceptSelected);
            }

            var responseType = 'json';

            if (httpHeaderAcceptSelected && httpHeaderAcceptSelected.startsWith('text')) {
              responseType = 'text';
            }

            return this.httpClient.get("".concat(this.configuration.basePath, "/medicationcontainers/findByCustomerId/").concat(encodeURIComponent(String(consumerId))), {
              responseType: responseType,
              withCredentials: this.configuration.withCredentials,
              headers: headers,
              observe: observe,
              reportProgress: reportProgress
            });
          }
        }, {
          key: "getMedicationContainer",
          value: function getMedicationContainer(containerId) {
            var observe = arguments.length > 1 && arguments[1] !== undefined ? arguments[1] : 'body';
            var reportProgress = arguments.length > 2 && arguments[2] !== undefined ? arguments[2] : false;
            var options = arguments.length > 3 ? arguments[3] : undefined;

            if (containerId === null || containerId === undefined) {
              throw new Error('Required parameter containerId was null or undefined when calling getMedicationContainer.');
            }

            var headers = this.defaultHeaders;
            var httpHeaderAcceptSelected = options && options.httpHeaderAccept;

            if (httpHeaderAcceptSelected === undefined) {
              // to determine the Accept header
              var httpHeaderAccepts = ['application/json'];
              httpHeaderAcceptSelected = this.configuration.selectHeaderAccept(httpHeaderAccepts);
            }

            if (httpHeaderAcceptSelected !== undefined) {
              headers = headers.set('Accept', httpHeaderAcceptSelected);
            }

            var responseType = 'json';

            if (httpHeaderAcceptSelected && httpHeaderAcceptSelected.startsWith('text')) {
              responseType = 'text';
            }

            return this.httpClient.get("".concat(this.configuration.basePath, "/medicationcontainers/").concat(encodeURIComponent(String(containerId))), {
              responseType: responseType,
              withCredentials: this.configuration.withCredentials,
              headers: headers,
              observe: observe,
              reportProgress: reportProgress
            });
          }
        }, {
          key: "getMedicationContainers",
          value: function getMedicationContainers() {
            var observe = arguments.length > 0 && arguments[0] !== undefined ? arguments[0] : 'body';
            var reportProgress = arguments.length > 1 && arguments[1] !== undefined ? arguments[1] : false;
            var options = arguments.length > 2 ? arguments[2] : undefined;
            var headers = this.defaultHeaders;
            var httpHeaderAcceptSelected = options && options.httpHeaderAccept;

            if (httpHeaderAcceptSelected === undefined) {
              // to determine the Accept header
              var httpHeaderAccepts = ['application/json'];
              httpHeaderAcceptSelected = this.configuration.selectHeaderAccept(httpHeaderAccepts);
            }

            if (httpHeaderAcceptSelected !== undefined) {
              headers = headers.set('Accept', httpHeaderAcceptSelected);
            }

            var responseType = 'json';

            if (httpHeaderAcceptSelected && httpHeaderAcceptSelected.startsWith('text')) {
              responseType = 'text';
            }

            return this.httpClient.get("".concat(this.configuration.basePath, "/medicationcontainers"), {
              responseType: responseType,
              withCredentials: this.configuration.withCredentials,
              headers: headers,
              observe: observe,
              reportProgress: reportProgress
            });
          }
        }, {
          key: "updateMedicationContainer",
          value: function updateMedicationContainer(containerId, medicationcontainerDTO) {
            var observe = arguments.length > 2 && arguments[2] !== undefined ? arguments[2] : 'body';
            var reportProgress = arguments.length > 3 && arguments[3] !== undefined ? arguments[3] : false;
            var options = arguments.length > 4 ? arguments[4] : undefined;

            if (containerId === null || containerId === undefined) {
              throw new Error('Required parameter containerId was null or undefined when calling updateMedicationContainer.');
            }

            if (medicationcontainerDTO === null || medicationcontainerDTO === undefined) {
              throw new Error('Required parameter medicationcontainerDTO was null or undefined when calling updateMedicationContainer.');
            }

            var headers = this.defaultHeaders;
            var httpHeaderAcceptSelected = options && options.httpHeaderAccept;

            if (httpHeaderAcceptSelected === undefined) {
              // to determine the Accept header
              var httpHeaderAccepts = [];
              httpHeaderAcceptSelected = this.configuration.selectHeaderAccept(httpHeaderAccepts);
            }

            if (httpHeaderAcceptSelected !== undefined) {
              headers = headers.set('Accept', httpHeaderAcceptSelected);
            } // to determine the Content-Type header


            var consumes = ['application/json'];
            var httpContentTypeSelected = this.configuration.selectHeaderContentType(consumes);

            if (httpContentTypeSelected !== undefined) {
              headers = headers.set('Content-Type', httpContentTypeSelected);
            }

            var responseType = 'json';

            if (httpHeaderAcceptSelected && httpHeaderAcceptSelected.startsWith('text')) {
              responseType = 'text';
            }

            return this.httpClient.put("".concat(this.configuration.basePath, "/medicationcontainers/").concat(encodeURIComponent(String(containerId))), medicationcontainerDTO, {
              responseType: responseType,
              withCredentials: this.configuration.withCredentials,
              headers: headers,
              observe: observe,
              reportProgress: reportProgress
            });
          }
        }]);

        return MedicationsService;
      }();

      MedicationsService.ɵfac = function MedicationsService_Factory(t) {
        return new (t || MedicationsService)(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵinject"](_angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpClient"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵinject"](_variables__WEBPACK_IMPORTED_MODULE_3__["BASE_PATH"], 8), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵinject"](_configuration__WEBPACK_IMPORTED_MODULE_4__["Configuration"], 8));
      };

      MedicationsService.ɵprov = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjectable"]({
        token: MedicationsService,
        factory: MedicationsService.ɵfac,
        providedIn: 'root'
      });
      /*@__PURE__*/

      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](MedicationsService, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Injectable"],
          args: [{
            providedIn: 'root'
          }]
        }], function () {
          return [{
            type: _angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpClient"]
          }, {
            type: undefined,
            decorators: [{
              type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Optional"]
            }, {
              type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Inject"],
              args: [_variables__WEBPACK_IMPORTED_MODULE_3__["BASE_PATH"]]
            }]
          }, {
            type: _configuration__WEBPACK_IMPORTED_MODULE_4__["Configuration"],
            decorators: [{
              type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Optional"]
            }]
          }];
        }, null);
      })();
      /***/

    },

    /***/
    "THpc":
    /*!****************************************************!*\
      !*** ./src/app/generatedWawi/model/pharmacyDTO.ts ***!
      \****************************************************/

    /*! no exports provided */

    /***/
    function THpc(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /**
       * WAWI api
       * API of WAWI
       *
       * The version of the OpenAPI document: 1.0.0
       *
       *
       * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
       * https://openapi-generator.tech
       * Do not edit the class manually.
       */

      /***/

    },

    /***/
    "UyeY":
    /*!****************************************!*\
      !*** ./src/app/generatedWawi/index.ts ***!
      \****************************************/

    /*! exports provided: PharmacyService, APIS, BASE_PATH, COLLECTION_FORMATS, Configuration, ApiModule */

    /***/
    function UyeY(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony import */


      var _api_api__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(
      /*! ./api/api */
      "t/9T");
      /* harmony reexport (safe) */


      __webpack_require__.d(__webpack_exports__, "PharmacyService", function () {
        return _api_api__WEBPACK_IMPORTED_MODULE_0__["PharmacyService"];
      });
      /* harmony reexport (safe) */


      __webpack_require__.d(__webpack_exports__, "APIS", function () {
        return _api_api__WEBPACK_IMPORTED_MODULE_0__["APIS"];
      });
      /* harmony import */


      var _model_models__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(
      /*! ./model/models */
      "KVkJ");
      /* empty/unused harmony star reexport */

      /* harmony import */


      var _variables__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(
      /*! ./variables */
      "wsM+");
      /* harmony reexport (safe) */


      __webpack_require__.d(__webpack_exports__, "BASE_PATH", function () {
        return _variables__WEBPACK_IMPORTED_MODULE_2__["BASE_PATH"];
      });
      /* harmony reexport (safe) */


      __webpack_require__.d(__webpack_exports__, "COLLECTION_FORMATS", function () {
        return _variables__WEBPACK_IMPORTED_MODULE_2__["COLLECTION_FORMATS"];
      });
      /* harmony import */


      var _configuration__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(
      /*! ./configuration */
      "PFOZ");
      /* harmony reexport (safe) */


      __webpack_require__.d(__webpack_exports__, "Configuration", function () {
        return _configuration__WEBPACK_IMPORTED_MODULE_3__["Configuration"];
      });
      /* harmony import */


      var _api_module__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(
      /*! ./api.module */
      "b+XV");
      /* harmony reexport (safe) */


      __webpack_require__.d(__webpack_exports__, "ApiModule", function () {
        return _api_module__WEBPACK_IMPORTED_MODULE_4__["ApiModule"];
      });
      /***/

    },

    /***/
    "ZAI4":
    /*!*******************************!*\
      !*** ./src/app/app.module.ts ***!
      \*******************************/

    /*! exports provided: AppModule */

    /***/
    function ZAI4(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */


      __webpack_require__.d(__webpack_exports__, "AppModule", function () {
        return AppModule;
      });
      /* harmony import */


      var _angular_platform_browser__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(
      /*! @angular/platform-browser */
      "jhN1");
      /* harmony import */


      var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(
      /*! @angular/core */
      "fXoL");
      /* harmony import */


      var _app_routing_module__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(
      /*! ./app-routing.module */
      "vY5A");
      /* harmony import */


      var _app_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(
      /*! ./app.component */
      "Sy1n");
      /* harmony import */


      var _angular_platform_browser_animations__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(
      /*! @angular/platform-browser/animations */
      "R1ws");
      /* harmony import */


      var _angular_material_grid_list__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(
      /*! @angular/material/grid-list */
      "zkoq");
      /* harmony import */


      var _angular_material_table__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(
      /*! @angular/material/table */
      "+0xr");
      /* harmony import */


      var _angular_material_input__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(
      /*! @angular/material/input */
      "qFsG");
      /* harmony import */


      var _environments_environment__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(
      /*! ../environments/environment */
      "AytR");
      /* harmony import */


      var _angular_common_http__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(
      /*! @angular/common/http */
      "tk/3");
      /* harmony import */


      var _angular_material_core__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(
      /*! @angular/material/core */
      "FKr1");
      /* harmony import */


      var _angular_material_select__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(
      /*! @angular/material/select */
      "d3UM");
      /* harmony import */


      var _generatedCm__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(
      /*! ./generatedCm */
      "T01Q");
      /* harmony import */


      var _generatedWawi__WEBPACK_IMPORTED_MODULE_13__ = __webpack_require__(
      /*! ./generatedWawi */
      "UyeY");

      var AppModule = function AppModule() {
        _classCallCheck(this, AppModule);
      };

      AppModule.ɵmod = _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵdefineNgModule"]({
        type: AppModule,
        bootstrap: [_app_component__WEBPACK_IMPORTED_MODULE_3__["AppComponent"]]
      });
      AppModule.ɵinj = _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵdefineInjector"]({
        factory: function AppModule_Factory(t) {
          return new (t || AppModule)();
        },
        providers: [{
          provide: _generatedCm__WEBPACK_IMPORTED_MODULE_12__["BASE_PATH"],
          useValue: _environments_environment__WEBPACK_IMPORTED_MODULE_8__["environment"].API_BASE_PATH_CM
        }, {
          provide: _generatedWawi__WEBPACK_IMPORTED_MODULE_13__["BASE_PATH"],
          useValue: _environments_environment__WEBPACK_IMPORTED_MODULE_8__["environment"].API_BASE_PATH_WAWI
        }],
        imports: [[_angular_platform_browser__WEBPACK_IMPORTED_MODULE_0__["BrowserModule"], _app_routing_module__WEBPACK_IMPORTED_MODULE_2__["AppRoutingModule"], _angular_platform_browser_animations__WEBPACK_IMPORTED_MODULE_4__["NoopAnimationsModule"], _angular_material_grid_list__WEBPACK_IMPORTED_MODULE_5__["MatGridListModule"], _angular_material_table__WEBPACK_IMPORTED_MODULE_6__["MatTableModule"], _angular_material_input__WEBPACK_IMPORTED_MODULE_7__["MatInputModule"], _angular_material_core__WEBPACK_IMPORTED_MODULE_10__["MatOptionModule"], _angular_material_select__WEBPACK_IMPORTED_MODULE_11__["MatSelectModule"], _angular_common_http__WEBPACK_IMPORTED_MODULE_9__["HttpClientModule"]]]
      });

      (function () {
        (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵɵsetNgModuleScope"](AppModule, {
          declarations: [_app_component__WEBPACK_IMPORTED_MODULE_3__["AppComponent"]],
          imports: [_angular_platform_browser__WEBPACK_IMPORTED_MODULE_0__["BrowserModule"], _app_routing_module__WEBPACK_IMPORTED_MODULE_2__["AppRoutingModule"], _angular_platform_browser_animations__WEBPACK_IMPORTED_MODULE_4__["NoopAnimationsModule"], _angular_material_grid_list__WEBPACK_IMPORTED_MODULE_5__["MatGridListModule"], _angular_material_table__WEBPACK_IMPORTED_MODULE_6__["MatTableModule"], _angular_material_input__WEBPACK_IMPORTED_MODULE_7__["MatInputModule"], _angular_material_core__WEBPACK_IMPORTED_MODULE_10__["MatOptionModule"], _angular_material_select__WEBPACK_IMPORTED_MODULE_11__["MatSelectModule"], _angular_common_http__WEBPACK_IMPORTED_MODULE_9__["HttpClientModule"]]
        });
      })();
      /*@__PURE__*/


      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_1__["ɵsetClassMetadata"](AppModule, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_1__["NgModule"],
          args: [{
            declarations: [_app_component__WEBPACK_IMPORTED_MODULE_3__["AppComponent"]],
            imports: [_angular_platform_browser__WEBPACK_IMPORTED_MODULE_0__["BrowserModule"], _app_routing_module__WEBPACK_IMPORTED_MODULE_2__["AppRoutingModule"], _angular_platform_browser_animations__WEBPACK_IMPORTED_MODULE_4__["NoopAnimationsModule"], _angular_material_grid_list__WEBPACK_IMPORTED_MODULE_5__["MatGridListModule"], _angular_material_table__WEBPACK_IMPORTED_MODULE_6__["MatTableModule"], _angular_material_input__WEBPACK_IMPORTED_MODULE_7__["MatInputModule"], _angular_material_core__WEBPACK_IMPORTED_MODULE_10__["MatOptionModule"], _angular_material_select__WEBPACK_IMPORTED_MODULE_11__["MatSelectModule"], _angular_common_http__WEBPACK_IMPORTED_MODULE_9__["HttpClientModule"]],
            providers: [{
              provide: _generatedCm__WEBPACK_IMPORTED_MODULE_12__["BASE_PATH"],
              useValue: _environments_environment__WEBPACK_IMPORTED_MODULE_8__["environment"].API_BASE_PATH_CM
            }, {
              provide: _generatedWawi__WEBPACK_IMPORTED_MODULE_13__["BASE_PATH"],
              useValue: _environments_environment__WEBPACK_IMPORTED_MODULE_8__["environment"].API_BASE_PATH_WAWI
            }],
            bootstrap: [_app_component__WEBPACK_IMPORTED_MODULE_3__["AppComponent"]]
          }]
        }], null, null);
      })();
      /***/

    },

    /***/
    "b+XV":
    /*!*********************************************!*\
      !*** ./src/app/generatedWawi/api.module.ts ***!
      \*********************************************/

    /*! exports provided: ApiModule */

    /***/
    function bXV(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */


      __webpack_require__.d(__webpack_exports__, "ApiModule", function () {
        return ApiModule;
      });
      /* harmony import */


      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(
      /*! @angular/core */
      "fXoL");
      /* harmony import */


      var _configuration__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(
      /*! ./configuration */
      "PFOZ");
      /* harmony import */


      var _angular_common_http__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(
      /*! @angular/common/http */
      "tk/3");

      var ApiModule = /*#__PURE__*/function () {
        function ApiModule(parentModule, http) {
          _classCallCheck(this, ApiModule);

          if (parentModule) {
            throw new Error('ApiModule is already loaded. Import in your base AppModule only.');
          }

          if (!http) {
            throw new Error('You need to import the HttpClientModule in your AppModule! \n' + 'See also https://github.com/angular/angular/issues/20575');
          }
        }

        _createClass(ApiModule, null, [{
          key: "forRoot",
          value: function forRoot(configurationFactory) {
            return {
              ngModule: ApiModule,
              providers: [{
                provide: _configuration__WEBPACK_IMPORTED_MODULE_1__["Configuration"],
                useFactory: configurationFactory
              }]
            };
          }
        }]);

        return ApiModule;
      }();

      ApiModule.ɵmod = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineNgModule"]({
        type: ApiModule
      });
      ApiModule.ɵinj = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjector"]({
        factory: function ApiModule_Factory(t) {
          return new (t || ApiModule)(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵinject"](ApiModule, 12), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵinject"](_angular_common_http__WEBPACK_IMPORTED_MODULE_2__["HttpClient"], 8));
        },
        providers: [],
        imports: [[]]
      });
      /*@__PURE__*/

      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](ApiModule, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"],
          args: [{
            imports: [],
            declarations: [],
            exports: [],
            providers: []
          }]
        }], function () {
          return [{
            type: ApiModule,
            decorators: [{
              type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Optional"]
            }, {
              type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["SkipSelf"]
            }]
          }, {
            type: _angular_common_http__WEBPACK_IMPORTED_MODULE_2__["HttpClient"],
            decorators: [{
              type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Optional"]
            }]
          }];
        }, null);
      })();
      /***/

    },

    /***/
    "bqOV":
    /*!**********************************************!*\
      !*** ./src/app/generatedCm/configuration.ts ***!
      \**********************************************/

    /*! exports provided: Configuration */

    /***/
    function bqOV(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */


      __webpack_require__.d(__webpack_exports__, "Configuration", function () {
        return Configuration;
      });

      var Configuration = /*#__PURE__*/function () {
        function Configuration() {
          var configurationParameters = arguments.length > 0 && arguments[0] !== undefined ? arguments[0] : {};

          _classCallCheck(this, Configuration);

          this.apiKeys = configurationParameters.apiKeys;
          this.username = configurationParameters.username;
          this.password = configurationParameters.password;
          this.accessToken = configurationParameters.accessToken;
          this.basePath = configurationParameters.basePath;
          this.withCredentials = configurationParameters.withCredentials;
          this.encoder = configurationParameters.encoder;
        }
        /**
         * Select the correct content-type to use for a request.
         * Uses {@link Configuration#isJsonMime} to determine the correct content-type.
         * If no content type is found return the first found type if the contentTypes is not empty
         * @param contentTypes - the array of content types that are available for selection
         * @returns the selected content-type or <code>undefined</code> if no selection could be made.
         */


        _createClass(Configuration, [{
          key: "selectHeaderContentType",
          value: function selectHeaderContentType(contentTypes) {
            var _this6 = this;

            if (contentTypes.length === 0) {
              return undefined;
            }

            var type = contentTypes.find(function (x) {
              return _this6.isJsonMime(x);
            });

            if (type === undefined) {
              return contentTypes[0];
            }

            return type;
          }
          /**
           * Select the correct accept content-type to use for a request.
           * Uses {@link Configuration#isJsonMime} to determine the correct accept content-type.
           * If no content type is found return the first found type if the contentTypes is not empty
           * @param accepts - the array of content types that are available for selection.
           * @returns the selected content-type or <code>undefined</code> if no selection could be made.
           */

        }, {
          key: "selectHeaderAccept",
          value: function selectHeaderAccept(accepts) {
            var _this7 = this;

            if (accepts.length === 0) {
              return undefined;
            }

            var type = accepts.find(function (x) {
              return _this7.isJsonMime(x);
            });

            if (type === undefined) {
              return accepts[0];
            }

            return type;
          }
          /**
           * Check if the given MIME is a JSON MIME.
           * JSON MIME examples:
           *   application/json
           *   application/json; charset=UTF8
           *   APPLICATION/JSON
           *   application/vnd.company+json
           * @param mime - MIME (Multipurpose Internet Mail Extensions)
           * @return True if the given MIME is JSON, false otherwise.
           */

        }, {
          key: "isJsonMime",
          value: function isJsonMime(mime) {
            var jsonMime = new RegExp('^(application\/json|[^;/ \t]+\/[^;/ \t]+[+]json)[ \t]*(;.*)?$', 'i');
            return mime !== null && (jsonMime.test(mime) || mime.toLowerCase() === 'application/json-patch+json');
          }
        }]);

        return Configuration;
      }();
      /***/

    },

    /***/
    "el7H":
    /*!****************************************!*\
      !*** ./src/app/generatedCm/api/api.ts ***!
      \****************************************/

    /*! exports provided: MedicationsService, APIS */

    /***/
    function el7H(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */


      __webpack_require__.d(__webpack_exports__, "APIS", function () {
        return APIS;
      });
      /* harmony import */


      var _medications_service__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(
      /*! ./medications.service */
      "T0NR");
      /* harmony reexport (safe) */


      __webpack_require__.d(__webpack_exports__, "MedicationsService", function () {
        return _medications_service__WEBPACK_IMPORTED_MODULE_0__["MedicationsService"];
      });

      var APIS = [_medications_service__WEBPACK_IMPORTED_MODULE_0__["MedicationsService"]];
      /***/
    },

    /***/
    "t/9T":
    /*!******************************************!*\
      !*** ./src/app/generatedWawi/api/api.ts ***!
      \******************************************/

    /*! exports provided: PharmacyService, APIS */

    /***/
    function t9T(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */


      __webpack_require__.d(__webpack_exports__, "APIS", function () {
        return APIS;
      });
      /* harmony import */


      var _pharmacy_service__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(
      /*! ./pharmacy.service */
      "OoPK");
      /* harmony reexport (safe) */


      __webpack_require__.d(__webpack_exports__, "PharmacyService", function () {
        return _pharmacy_service__WEBPACK_IMPORTED_MODULE_0__["PharmacyService"];
      });

      var APIS = [_pharmacy_service__WEBPACK_IMPORTED_MODULE_0__["PharmacyService"]];
      /***/
    },

    /***/
    "vY5A":
    /*!***************************************!*\
      !*** ./src/app/app-routing.module.ts ***!
      \***************************************/

    /*! exports provided: AppRoutingModule */

    /***/
    function vY5A(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */


      __webpack_require__.d(__webpack_exports__, "AppRoutingModule", function () {
        return AppRoutingModule;
      });
      /* harmony import */


      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(
      /*! @angular/core */
      "fXoL");
      /* harmony import */


      var _angular_router__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(
      /*! @angular/router */
      "tyNb");

      var routes = [];

      var AppRoutingModule = function AppRoutingModule() {
        _classCallCheck(this, AppRoutingModule);
      };

      AppRoutingModule.ɵmod = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineNgModule"]({
        type: AppRoutingModule
      });
      AppRoutingModule.ɵinj = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjector"]({
        factory: function AppRoutingModule_Factory(t) {
          return new (t || AppRoutingModule)();
        },
        imports: [[_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"].forRoot(routes)], _angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]]
      });

      (function () {
        (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵsetNgModuleScope"](AppRoutingModule, {
          imports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]],
          exports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]]
        });
      })();
      /*@__PURE__*/


      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](AppRoutingModule, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"],
          args: [{
            imports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"].forRoot(routes)],
            exports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]]
          }]
        }], null, null);
      })();
      /***/

    },

    /***/
    "wsM+":
    /*!********************************************!*\
      !*** ./src/app/generatedWawi/variables.ts ***!
      \********************************************/

    /*! exports provided: BASE_PATH, COLLECTION_FORMATS */

    /***/
    function wsM(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */


      __webpack_require__.d(__webpack_exports__, "BASE_PATH", function () {
        return BASE_PATH;
      });
      /* harmony export (binding) */


      __webpack_require__.d(__webpack_exports__, "COLLECTION_FORMATS", function () {
        return COLLECTION_FORMATS;
      });
      /* harmony import */


      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(
      /*! @angular/core */
      "fXoL");

      var BASE_PATH = new _angular_core__WEBPACK_IMPORTED_MODULE_0__["InjectionToken"]('basePath');
      var COLLECTION_FORMATS = {
        'csv': ',',
        'tsv': '   ',
        'ssv': ' ',
        'pipes': '|'
      };
      /***/
    },

    /***/
    "z8r5":
    /*!*******************************************!*\
      !*** ./src/app/generatedCm/api.module.ts ***!
      \*******************************************/

    /*! exports provided: ApiModule */

    /***/
    function z8r5(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony export (binding) */


      __webpack_require__.d(__webpack_exports__, "ApiModule", function () {
        return ApiModule;
      });
      /* harmony import */


      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(
      /*! @angular/core */
      "fXoL");
      /* harmony import */


      var _configuration__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(
      /*! ./configuration */
      "bqOV");
      /* harmony import */


      var _angular_common_http__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(
      /*! @angular/common/http */
      "tk/3");

      var ApiModule = /*#__PURE__*/function () {
        function ApiModule(parentModule, http) {
          _classCallCheck(this, ApiModule);

          if (parentModule) {
            throw new Error('ApiModule is already loaded. Import in your base AppModule only.');
          }

          if (!http) {
            throw new Error('You need to import the HttpClientModule in your AppModule! \n' + 'See also https://github.com/angular/angular/issues/20575');
          }
        }

        _createClass(ApiModule, null, [{
          key: "forRoot",
          value: function forRoot(configurationFactory) {
            return {
              ngModule: ApiModule,
              providers: [{
                provide: _configuration__WEBPACK_IMPORTED_MODULE_1__["Configuration"],
                useFactory: configurationFactory
              }]
            };
          }
        }]);

        return ApiModule;
      }();

      ApiModule.ɵmod = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineNgModule"]({
        type: ApiModule
      });
      ApiModule.ɵinj = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjector"]({
        factory: function ApiModule_Factory(t) {
          return new (t || ApiModule)(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵinject"](ApiModule, 12), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵinject"](_angular_common_http__WEBPACK_IMPORTED_MODULE_2__["HttpClient"], 8));
        },
        providers: [],
        imports: [[]]
      });
      /*@__PURE__*/

      (function () {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](ApiModule, [{
          type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"],
          args: [{
            imports: [],
            declarations: [],
            exports: [],
            providers: []
          }]
        }], function () {
          return [{
            type: ApiModule,
            decorators: [{
              type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Optional"]
            }, {
              type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["SkipSelf"]
            }]
          }, {
            type: _angular_common_http__WEBPACK_IMPORTED_MODULE_2__["HttpClient"],
            decorators: [{
              type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Optional"]
            }]
          }];
        }, null);
      })();
      /***/

    },

    /***/
    "zUnb":
    /*!*********************!*\
      !*** ./src/main.ts ***!
      \*********************/

    /*! no exports provided */

    /***/
    function zUnb(module, __webpack_exports__, __webpack_require__) {
      "use strict";

      __webpack_require__.r(__webpack_exports__);
      /* harmony import */


      var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(
      /*! @angular/core */
      "fXoL");
      /* harmony import */


      var _environments_environment__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(
      /*! ./environments/environment */
      "AytR");
      /* harmony import */


      var _app_app_module__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(
      /*! ./app/app.module */
      "ZAI4");
      /* harmony import */


      var _angular_platform_browser__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(
      /*! @angular/platform-browser */
      "jhN1");

      if (_environments_environment__WEBPACK_IMPORTED_MODULE_1__["environment"].production) {
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["enableProdMode"])();
      }

      _angular_platform_browser__WEBPACK_IMPORTED_MODULE_3__["platformBrowser"]().bootstrapModule(_app_app_module__WEBPACK_IMPORTED_MODULE_2__["AppModule"])["catch"](function (err) {
        return console.error(err);
      });
      /***/

    },

    /***/
    "zn8P":
    /*!******************************************************!*\
      !*** ./$$_lazy_route_resource lazy namespace object ***!
      \******************************************************/

    /*! no static exports found */

    /***/
    function zn8P(module, exports) {
      function webpackEmptyAsyncContext(req) {
        // Here Promise.resolve().then() is used instead of new Promise() to prevent
        // uncaught exception popping up in devtools
        return Promise.resolve().then(function () {
          var e = new Error("Cannot find module '" + req + "'");
          e.code = 'MODULE_NOT_FOUND';
          throw e;
        });
      }

      webpackEmptyAsyncContext.keys = function () {
        return [];
      };

      webpackEmptyAsyncContext.resolve = webpackEmptyAsyncContext;
      module.exports = webpackEmptyAsyncContext;
      webpackEmptyAsyncContext.id = "zn8P";
      /***/
    }
  }, [[0, "runtime", "vendor"]]]);
})();
//# sourceMappingURL=main-es5.js.map