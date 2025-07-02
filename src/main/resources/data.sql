-- Initial data for Task Tracker Application
-- This file populates the tasks table with sample data

-- Insert sample tasks with different statuses and due dates
INSERT INTO tasks (title, description, status, due_date, created_at, updated_at) VALUES
('Complete Project Setup', 'Set up the basic Spring Boot project structure with all necessary dependencies', 'COMPLETED', '2024-01-15', '2024-01-10T09:00:00Z', '2024-01-15T14:30:00Z'),

('Implement User Authentication', 'Add Spring Security configuration for user login and registration', 'IN_PROGRESS', '2024-01-25', '2024-01-12T10:30:00Z', '2024-01-20T16:45:00Z'),

('Create REST API Endpoints', 'Develop CRUD operations for task management with proper HTTP methods', 'IN_PROGRESS', '2024-01-30', '2024-01-15T08:15:00Z', '2024-01-22T11:20:00Z'),

('Set up Database Schema', 'Design and implement the database schema with proper relationships', 'COMPLETED', '2024-01-20', '2024-01-08T14:00:00Z', '2024-01-18T17:00:00Z'),

('Write Unit Tests', 'Create comprehensive unit tests for all service and controller classes', 'TODO', '2024-02-05', '2024-01-18T09:45:00Z', '2024-01-18T09:45:00Z'),

('Implement Task Filtering', 'Add functionality to filter tasks by status, date, and priority', 'TODO', '2024-02-10', '2024-01-20T13:30:00Z', '2024-01-20T13:30:00Z'),

('Create Frontend Interface', 'Develop a responsive web interface for task management', 'TODO', '2024-02-15', '2024-01-22T11:00:00Z', '2024-01-22T11:00:00Z'),

('Add Task Categories', 'Implement categorization system for better task organization', 'PLANNED', '2024-02-20', '2024-01-23T10:15:00Z', '2024-01-23T10:15:00Z'),

('Implement Notifications', 'Add email/SMS notifications for task deadlines and updates', 'PLANNED', '2024-02-25', '2024-01-24T15:20:00Z', '2024-01-24T15:20:00Z'),

('Performance Optimization', 'Optimize database queries and implement caching where necessary', 'PLANNED', '2024-03-01', '2024-01-25T12:00:00Z', '2024-01-25T12:00:00Z'),

('Security Audit', 'Conduct comprehensive security review and implement security best practices', 'TODO', '2024-03-05', '2024-01-26T09:30:00Z', '2024-01-26T09:30:00Z'),

('Documentation', 'Create comprehensive API documentation and user guides', 'TODO', '2024-03-10', '2024-01-27T14:45:00Z', '2024-01-27T14:45:00Z'),

('Deployment Setup', 'Configure CI/CD pipeline and production deployment environment', 'PLANNED', '2024-03-15', '2024-01-28T16:00:00Z', '2024-01-28T16:00:00Z'),

('Load Testing', 'Perform load testing to ensure application can handle expected traffic', 'PLANNED', '2024-03-20', '2024-01-29T08:30:00Z', '2024-01-29T08:30:00Z'),

('Bug Fixes and Refinements', 'Address any remaining bugs and polish the user experience', 'PLANNED', '2024-03-25', '2024-01-30T11:15:00Z', '2024-01-30T11:15:00Z');

-- Note: The timestamps are in UTC format. Spring Boot will handle timezone conversion based on your application configuration. 