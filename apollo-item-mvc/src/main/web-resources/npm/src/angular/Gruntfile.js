module.exports = function(grunt) {

  // Project configuration.
  grunt.initConfig({
    pkg: grunt.file.readJSON('package.json'),
    uglify: {
      options: {
        preserveComments: 'some',
		beautify: false
      },
      core: {
        src: '<%= concat.core.dest %>',
        dest: 'dist/js/<%= pkg.name %>.min.js'
      }
    },
	clean: {
      dist: 'dist'
    },
	concat: {
      options: {
        banner: '<%= banner %>\n<%= jqueryCheck %>\n<%= jqueryVersionCheck %>',
        stripBanners: false
      },
      core: {
        src: [
          'js/apollo-item-app.js',
          'js/apollo-item-maintenance.js',
          'js/apollo-new-item.js',
          'js/apollo-item-history.js',
          'js/util.js'
        ],
        dest: 'dist/js/<%= pkg.name %>.js'
      }
    },
	usebanner: {
      options: {
        position: 'top',
        banner: '<%= banner %>'
      },
      files: {
        src: 'dist/css/*.css'
      }
    },
    less: {
        compileCore: {
          options: {
            strictMath: true,
            sourceMap: true,
            outputSourceFiles: true,
            sourceMapURL: '<%= pkg.name %>.css.map',
            sourceMapFilename: 'dist/css/<%= pkg.name %>.css.map'
          },
          src: 'less/root.less',
          dest: 'dist/css/<%= pkg.name %>.css'
        }
      },
      cssmin: {
          options: {
            compatibility: 'ie8',
            keepSpecialComments: '*',
            advanced: false
          },
          minifyCore: {
            src: 'dist/css/<%= pkg.name %>.css',
            dest: 'dist/css/<%= pkg.name %>.min.css'
          }
        }
  });

  // Load the plugin that provides the "uglify" task.
  require('load-grunt-tasks')(grunt, { scope: 'devDependencies' });

  // Full distribution task.
  grunt.registerTask('dist', ['clean:dist', 'dist-js', 'dist-less']);
  // JS distribution task.
  grunt.registerTask('dist-js', ['concat', 'uglify:core']);
  //Less distribution task
  grunt.registerTask('dist-less', ['less:compileCore', 'cssmin:minifyCore']);

};