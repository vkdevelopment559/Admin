-- Create the trigger function
CREATE OR REPLACE FUNCTION user_detail_trigger_generate_res_id()
RETURNS TRIGGER AS $$
BEGIN
    IF NEW.res_id IS NULL THEN
        NEW.res_id := nextval('res_id_sequence_user_detail');
    END IF;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

-- Create the trigger
CREATE TRIGGER user_detail_res_id_trigger
BEFORE INSERT ON user_detail
FOR EACH ROW
EXECUTE FUNCTION user_detail_trigger_generate_res_id();