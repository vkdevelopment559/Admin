-- Create the trigger function
CREATE OR REPLACE FUNCTION book_detail_trigger_generate_res_id()
RETURNS TRIGGER AS $$
BEGIN
    IF NEW.res_id IS NULL THEN
        NEW.res_id := nextval('res_id_sequence_book_detail');
    END IF;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

-- Create the trigger
CREATE TRIGGER book_detail_res_id_trigger
BEFORE INSERT ON book
FOR EACH ROW
EXECUTE FUNCTION book_detail_trigger_generate_res_id();