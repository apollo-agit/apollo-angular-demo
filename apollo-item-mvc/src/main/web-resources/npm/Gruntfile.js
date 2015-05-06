module.exports = function(grunt) {

  // Project configuration.
	grunt.initConfig({
	  hub: {
		all: {
		  src: ['src/bootstrap/Gruntfile.js', 'src/angular/Gruntfile.js'],
		  tasks: ['dist'],
		},
	  },
	  copy: {
		  js: {
			 files : [
				{expand: true, flatten: true, cwd: 'src/bootstrap/dist/js/', src: '*.js', dest: 'dist/js/', filter: 'isFile'},
				{expand: true, flatten: true, cwd: 'src/angular/dist/js/', src: '*.js',dest: 'dist/js/', filter: 'isFile'}
			 ]
		},
		css: {
			 files : [
				{expand: true, flatten: true, cwd: 'src/bootstrap/dist/css/', src: '**', dest: 'dist/css/', filter: 'isFile'},
				{expand: true, flatten: true, cwd: 'src/angular/dist/css/', src: '**', dest: 'dist/css/', filter: 'isFile'},
			 ]
		},
		fonts: {
			 files : [
				{expand: true, flatten: true, cwd: 'src/bootstrap/dist/fonts/', src: '**', dest: 'dist/fonts/', filter: 'isFile'}
			 ]
		}
	  }
	});


  require('load-grunt-tasks')(grunt, { scope: 'devDependencies' });

  grunt.registerTask('default', ['hub:all', 'copy:js', 'copy:css', 'copy:fonts']);

};