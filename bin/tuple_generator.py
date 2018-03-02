#!/usr/bin/env python

import os
import string

if __name__ == '__main__':
    script_dir = os.path.dirname(os.path.realpath(__file__))
    output_dir = os.path.join(os.path.dirname(script_dir),
                              'src', 'main', 'java', 'com', 'andrewjamesjohnson', 'junit', 'tuple')

    with open(os.path.join(script_dir, 'TupleParameter.java.template'), 'r') as template_file:
        template = template_file.read()
        for num_elements in range(1, 27):
            fields = map(lambda i: '_%d' % i, range(1, num_elements + 1))
            generics = string.ascii_uppercase[0:num_elements]


            def combiner(joiner, format_str):
                return joiner.join(map(lambda (f, g): format_str % {'generic': g, 'field': f}, zip(fields, generics)))


            template_params = {
                'num_elements': num_elements,
                'generic_types': ', '.join(generics),
                'field_names': ', '.join(fields),
                'field_decls': combiner('\n\t', 'public %(generic)s %(field)s;'),
                'field_params': combiner(', ', '%(generic)s %(field)s'),
                'field_setters': combiner('\n\t\t', 'this.%(field)s = %(field)s;')
            }
            with open(os.path.join(output_dir, 'Tuple%d.java' % num_elements), 'w') as output_file:
                output_file.write(template % template_params)
